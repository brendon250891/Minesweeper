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
public enum Difficulty {
    NONE(0),
    BEGINNER(10),
    INTERMEDIATE(40),
    EXPERT(99);
    
    private int mineCount;

    private Difficulty(int mineCount) {
        this.mineCount = mineCount;
    }

    public int getMineCount() {
        return this.mineCount;
    }
}
