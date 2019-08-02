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
    // The position of the Tiles x axis position in the grid.
    private int xPosition;
    
    // The position of the Tiles y axis positiion in the grid.
    private int yPosition;
    
    // The label of the Tile given it's position relative to mines.
    private String tileLabel = "0";
    
    // Flag to indicate if the Tile has been revealed.
    private boolean isTileRevealed = false;
    
    // Flag to indicate if the Tile has been Flagged as a potential mine Tile.
    private boolean isTileFlagged = false;
    
    
    /**
     * Default constructor.
     * @param xPosition - The x axis position of the Tile in the grid.
     * @param yPosition - The y axis position of the Tile in the grid.
     */
    public Tile(int xPosition, int yPosition) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }
    
    /**
     * Gets the x axis position of the Tile.
     * @return - The Tiles x axis position.
     */
    public int getXPosition() {
        return this.xPosition;
    }
    
    /**
     * Gets the y axis position of the Tile.
     * @return - The Tiles y axis position.
     */
    public int getYPosition() {
        return this.yPosition;
    }
    
    /**
     * Gets the label to be displayed on a revealed Tile.
     * @return - The label of the Tile.
     */
    public String getTileLabel() {
        return this.tileLabel.equalsIgnoreCase("0") ? "" : this.tileLabel;
    }
    
     /** 
      * Increments the Tile label by one. 
      */
    public void incrementAdjacentMineCount() {
        try {
            int tileLabel = Integer.parseInt(this.tileLabel);
            tileLabel++;
            this.tileLabel = Integer.toString(tileLabel);
        } catch (Exception e) {
            
        }
    }
    
    /**
     * Sets the Tile label to indicate that it's a mine.
     */
    public void setMineTile() {
        this.tileLabel = "B";
    }
    
    /**
     * Checks if the Tile is a mine.
     * @return - true if the Tile is a mine
     */
    public boolean isMineTile() {
        return this.tileLabel.equalsIgnoreCase("b");
    }
    
    /**
     * Gets the number of adjacent mines to the Tile.
     * @return - The number of adjacent mines as an Integer.
     */
    public int getAdjacentMineCount() {
        try {
            return Integer.parseInt(this.tileLabel);
        } catch (Exception e) {
            
        }
        return -1;
    }
    
    /**
     * Sets the Tile as revealed.
     */
    public void revealTile() {
        this.isTileRevealed = true;
    }
    
    /**
     * Checks if the Tile has been revealed.
     * @return - true if the Tile has been revealed.
     */
    public boolean isTileRevealed() {
        return this.isTileRevealed;
    }
    
    /**
     * Sets the tile as flagged.
     */
    public void flagTile() {
        this.isTileFlagged = !this.isTileFlagged;
    }
    
    /**
     * Checks if the Tile has been set to flagged.
     * @return - true if the Tile has been flagged.
     */
    public boolean isTileFlagged() {
        return this.isTileFlagged;
    }
}
