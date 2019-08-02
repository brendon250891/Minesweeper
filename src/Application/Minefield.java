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
        this.gridWidth = determineGridWidth();
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
    
    public Tile getTile(int xPosition, int yPosition) {
        return tiles[xPosition][yPosition];
    }

    private void instantiateTiles() {
        for (int x = 0; x < this.gridWidth; x++) {
            for (int y = 0; y < this.gridHeight; y++) {
                tiles[x][y] = new Tile(x, y);
            }
        }
        randomizeMineTiles();
    }

    public void selectTile(Tile tile, boolean flag) {
        if (flag) {
            tile.flagTile();
            callback.flagTile(tile);
        } else if (!tile.isTileFlagged()) {
            if (!tile.isTileRevealed() && tile.getAdjacentMineCount() == 0) {
                tile.revealTile();
                revealNeighborhood(tile);
            } else if (tile.isMineTile()) {
                tile.revealTile();
                callback.displayTile(tile);
                revealMinefield();
            } else if (!tile.isTileFlagged()) {
                tile.revealTile();
                callback.displayTile(tile);
                checkForResult();
            }
        }
    }
   
    
    private void revealMinefield() {
        for (int x = 0; x < this.gridWidth; x++) {
            for (int y = 0; y < this.gridHeight; y++) {
                Tile tile = tiles[x][y];
                if (!tile.isTileRevealed()) {
                    callback.displayTile(tile);
                }
            }
        }
        callback.gameOver(false);
        tiles = null;
    }
    
    private int determineGridWidth() {
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
            Tile tile = tiles[randomX][randomY];
            if (!tile.isMineTile()) {
                tile.setMineTile();
                incrementAdjacentMineCount(tile);
                i++;
            }
        }
    }

    private void incrementAdjacentMineCount(Tile tile) {
        for (int x = tile.getXPosition() - 1; x < tile.getXPosition() + 2; x++) {
            for (int y = tile.getYPosition() - 1; y < tile.getYPosition() + 2; y++) {
                if (x > - 1 && x < this.gridWidth && y > -1 && y < this.gridHeight && !tiles[x][y].isMineTile()) {
                    tiles[x][y].incrementAdjacentMineCount();
                }
            }
        }
    }

    private void revealNeighborhood(Tile tile) {
        for (int x = tile.getXPosition() - 1; x < tile.getXPosition() + 2; x++) {
            for (int y = tile.getYPosition() - 1; y < tile.getYPosition() + 2; y++) {
                if (x > -1 && x < this.gridWidth && y > -1 && y < this.gridHeight) {
                    callback.displayTile(tile);
                    selectTile(tiles[x][y], false);
                }
            }
        }
    }
    
    private void checkForResult() {
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
