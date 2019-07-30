/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.Point;
import javax.swing.JButton;

/**
 *
 * @author brendon
 */
public class MinesweeperTile extends JButton {
    private Point positionInGrid;
    private boolean isTileBomb = false;
    private boolean isTileFlagged = false;
    private int adjacentMineCount = 0;
    private boolean hasBeenVisited = false;
    
    public MinesweeperTile(Point positionInGrid) {
        this.positionInGrid = positionInGrid;
    }
    
    public Point getPoint() {
        return positionInGrid;
    }
    
    public void setPoint(int x, int y) {
        this.positionInGrid.x = x;
        this.positionInGrid.y = y;
    }
    
    public int getPointX() {
        return this.positionInGrid.x;
    }
    
    public int getPointY() {
        return this.positionInGrid.y;
    }
    
    public boolean isBombTile() {
        return this.isTileBomb;
    }
    
    public void setBombTile() {
        this.isTileBomb = true;
        this.adjacentMineCount = -1;
    }
    
    public void flagTile() {
        this.isTileFlagged = !this.isTileFlagged;
    }
    
    public boolean isTileFlagged() {
        return this.isTileFlagged;
    }
    
    public void incrementAdjacentMineCount() {
        this.adjacentMineCount++;
    }
    
    public int getAdjacentMineCount() {
        return this.adjacentMineCount;
    }
    
    public void visited() {
        this.hasBeenVisited = !this.hasBeenVisited;
    }
    
    public boolean hasBeenVisited() {
        return this.hasBeenVisited;
    }
}
