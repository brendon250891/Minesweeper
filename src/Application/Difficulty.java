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
enum Difficulty {
    BEGINNER(10),
    INTERMEDIATE(40),
    EXPERT(99);
    private int bombCount;

    private Difficulty(int bombCount) {
        this.bombCount = bombCount;
    }

    public int getBombCount() {
        return this.bombCount;
    }
}
