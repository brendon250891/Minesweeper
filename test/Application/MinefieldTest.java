/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author brendon
 */
public class MinefieldTest {
    
    public MinefieldTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getGridWidth method, of class Minefield.
     */
    @Test
    public void testGetGridWidth() {
        System.out.println("getGridWidth");
        Minefield instance = null;
        int expResult = 0;
        int result = instance.getGridWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGridHeight method, of class Minefield.
     */
    @Test
    public void testGetGridHeight() {
        System.out.println("getGridHeight");
        Minefield instance = null;
        int expResult = 0;
        int result = instance.getGridHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDifficulty method, of class Minefield.
     */
    @Test
    public void testGetDifficulty() {
        System.out.println("getDifficulty");
        Minefield instance = null;
        Difficulty expResult = null;
        Difficulty result = instance.getDifficulty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTile method, of class Minefield.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        int xPosition = 0;
        int yPosition = 0;
        Minefield instance = null;
        Tile expResult = null;
        Tile result = instance.getTile(xPosition, yPosition);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selectTile method, of class Minefield.
     */
    @Test
    public void testSelectTile(Tile tile) {
        System.out.println("selectTile");
        int xPosition = 0;
        int yPosition = 0;
        boolean flag = false;
        Minefield instance = null;
        instance.selectTile(tile, flag);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of revealMinefield method, of class Minefield.
     */
    @Test
    public void testRevealMinefield() {
        System.out.println("revealMinefield");
        Minefield instance = null;
        instance.revealMinefield();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
