/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.util.Random;

/**
 *
 * @author brendon
 */
public class Minefield {

    public Callback callback;
    private int gridLength;
    private Tile[][] tiles;
    private Difficulty gameDifficulty;

    public Minefield(int gridLength, Difficulty gameDifficulty) {
        this.gridLength = gridLength;
        this.tiles = new Tile[gridLength][gridLength];
        this.gameDifficulty = gameDifficulty;
        instantiateTiles();
    }

    // Returns the length of the grid.
    public int getGridLength() {
        return this.gridLength;
    }

    public Tile getTile(int xPosition, int yPosition) {
        return tiles[xPosition][yPosition];
    }

    private void instantiateTiles() {
        for (int x = 0; x < gridLength; x++) {
            for (int y = 0; y < gridLength; y++) {
                tiles[x][y] = new Tile(x, y);
            }
        }
        randomizeMineTiles();
    }

    public void selectTile(int xPosition, int yPosition, boolean flag) {
        Tile tile = tiles[xPosition][yPosition];
        if (flag) {
            tile.flagTile();
            callback.flagTile(xPosition, yPosition);
        } else if (!tile.isTileRevealed() && tile.getAdjacentMineCount() == 0) {
            tile.revealTile();
            revealNeighborhood(xPosition, yPosition);
        } else if (tile.isMineTile()) {
            callback.displayTile(xPosition, yPosition, "B");
        } else {
            tile.revealTile();
            callback.displayTile(xPosition, yPosition, tile.getAdjacentMineCount() == 0 ? "" 
                    : Integer.toString(tile.getAdjacentMineCount()));
        }
    }
    
    public void revealMinefield() {
        for (int x = 0; x < gridLength; x++) {
            for (int y = 0; y < gridLength; y++) {
                Tile tile = tiles[x][y];
                if (!tile.isTileRevealed()) {
                    String label = tile.isMineTile() ? "B" : tile.getAdjacentMineCount() == 0 ? 
                            "" : Integer.toString(tile.getAdjacentMineCount());
                    callback.displayTile(x, y, label);
                }
            }
        }
    }

    private void randomizeMineTiles() {
        Random random = new Random();
        int i = 0;
        while (i < gameDifficulty.getBombCount()) {
            int randomX = random.nextInt(8);
            int randomY = random.nextInt(8);
            if (!tiles[randomX][randomY].isMineTile()) {
                tiles[randomX][randomY].setMineTile();
                incrementAdjacentMineCount(randomX, randomY);
                i++;
            }
        }
    }

    private void incrementAdjacentMineCount(int x, int y) {
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i > - 1 && i < gridLength && j > -1 && j < gridLength && !tiles[i][j].isMineTile()) {
                    tiles[i][j].incrementAdjacentMineCount();
                }
            }
        }
    }

    private void revealNeighborhood(int xPosition, int yPosition) {
        for (int x = xPosition - 1; x < xPosition + 2; x++) {
            for (int y = yPosition - 1; y < yPosition + 2; y++) {
                if (x > -1 && x < gridLength && y > -1 && y < gridLength) {
                    Tile tile = tiles[x][y];
                    callback.displayTile(x, y, String.format("%s",tile.getAdjacentMineCount()));
                    selectTile(x, y, false);
                }
            }
        }
    }
}
