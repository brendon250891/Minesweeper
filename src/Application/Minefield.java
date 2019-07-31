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
    private int gridWidth;
    private int gridHeight;
    private Tile[][] tiles;
    private Difficulty gameDifficulty;

    public Minefield(Difficulty gameDifficulty) {
        this.gameDifficulty = gameDifficulty;
        this.gridWidth = determineGridLength();
        this.gridHeight = this.gridWidth == 30 ? 16 : this.gridWidth;
        this.tiles = new Tile[gridWidth][gridHeight];
        instantiateTiles();
    }

    // Returns the length of the grid.
    public int getGridWidth() {
        return this.gridWidth;
    }
    
    public int getGridHeight() {
        return this.gridHeight;
    }
    
    public Difficulty getDifficulty() {
        return this.gameDifficulty;
    }

    public Tile getTile(int xPosition, int yPosition) {
        return tiles[xPosition][yPosition];
    }

    private void instantiateTiles() {
        for (int x = 0; x < this.gridWidth; x++) {
            for (int y = 0; y < this.gridHeight; y++) {
                tiles[x][y] = new Tile();
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
            tile.revealTile();
            callback.displayTile(xPosition, yPosition, "B");
            revealMinefield();
        } else if (!tile.isTileFlagged()) {
            tile.revealTile();
            callback.displayTile(xPosition, yPosition, tile.getAdjacentMineCount() == 0 ? "" 
                    : Integer.toString(tile.getAdjacentMineCount()));
            checkForWin();
        }
    }
   
    
    public void revealMinefield() {
        for (int x = 0; x < this.gridWidth; x++) {
            for (int y = 0; y < this.gridHeight; y++) {
                Tile tile = tiles[x][y];
                if (!tile.isTileRevealed()) {
                    String label = tile.isMineTile() ? "B" : tile.getAdjacentMineCount() == 0 ? 
                            "" : Integer.toString(tile.getAdjacentMineCount());
                    callback.displayTile(x, y, label);
                }
            }
        }
        callback.gameOver(false);
        tiles = null;
    }
    
    private int determineGridLength() {
        switch (this.gameDifficulty) {
            case BEGINNER: return 9;
            case INTERMEDIATE: return 16;
            case EXPERT: return 30;
        }
        return 0;
    }

    private void randomizeMineTiles() {
        Random random = new Random();
        int i = 0;
        while (i < gameDifficulty.getMineCount()) {
            int randomX = random.nextInt(this.gridWidth - 1);
            int randomY = random.nextInt(this.gridHeight - 1);
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
                if (i > - 1 && i < this.gridWidth && j > -1 && j < this.gridHeight && !tiles[i][j].isMineTile()) {
                    tiles[i][j].incrementAdjacentMineCount();
                }
            }
        }
    }

    private void revealNeighborhood(int xPosition, int yPosition) {
        for (int x = xPosition - 1; x < xPosition + 2; x++) {
            for (int y = yPosition - 1; y < yPosition + 2; y++) {
                if (x > -1 && x < this.gridWidth && y > -1 && y < this.gridHeight) {
                    Tile tile = tiles[x][y];
                    callback.displayTile(x, y, String.format("%s",tile.getAdjacentMineCount()));
                    selectTile(x, y, false);
                }
            }
        }
    }
    
    private void checkForWin() {
        int unrevealedCount = 0;
        for (int x = 0; x < this.gridWidth; x++) {
            for (int y = 0; y < this.gridHeight; y++) {
                Tile tile = tiles[x][y];
                if (!tile.isTileRevealed()) {
                    unrevealedCount++;
                }
            }
        }
        if (unrevealedCount == gameDifficulty.getMineCount())
            callback.gameOver(true);
    }
}
