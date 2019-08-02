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
public interface Callback {
    void displayTile(Tile tile);
    void flagTile(Tile tile);
    void gameOver(boolean didWin);
}
