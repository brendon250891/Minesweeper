/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author brendon
 */
public class Tile {
    private int adjacentMineCount = 0;
    private boolean isMineTile = false;
    private boolean isTileRevealed = false;
    private boolean isTileFlagged = false;
    
    public Tile() {}

    // Increments the adjacent mine count by 1
    public void incrementAdjacentMineCount() {
        this.adjacentMineCount++;
    }
    
    // Indicates that the tile is a mine.
    public void setMineTile() {
        this.isMineTile = true;
        this.adjacentMineCount = -1;
    }
    
    // Returns whether the tile is a mine.
    public boolean isMineTile() {
        return this.isMineTile;
    }
    
    // Gets the number of adjacent mines to this tile.
    public int getAdjacentMineCount() {
        return this.adjacentMineCount;
    }
    
    // Sets the state of the tile to be revealed.
    public void revealTile() {
        this.isTileRevealed = true;
    }
    
    // Returns the current state of the tile.
    public boolean isTileRevealed() {
        return this.isTileRevealed;
    }
    
    // Flags the tile making it selectable and unrevealable.
    public void flagTile() {
        this.isTileFlagged = !this.isTileFlagged;
    }
    
    // Returns whether or not the tile has been flagged.
    public boolean isTileFlagged() {
        return this.isTileFlagged;
    }
}
