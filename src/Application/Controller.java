/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author brendon
 */
public class Controller implements Callback{

    private ApplicationView view;
    private Minefield minefield;
    private boolean isAGameRunning = false;
    private boolean isTimerRunning = false;

    public Controller(ApplicationView view) {
        this.view = view;
        setupSideBarButtons();
    }
    
    public void flagTile(int xPosition, int yPosition) {
        view.flagTile(xPosition, yPosition);
    }
    
    public void displayTile(int xPosition, int yPosition, String label) {
        if (label.equalsIgnoreCase("b")) {
            gameOver();
        } else {
            view.revealTile(xPosition, yPosition, label);
        }
    }

    // Sets up the sidebar buttons action listeners.
    private void setupSideBarButtons() {
        view.getPlayMinesweeperButton().addActionListener(e -> playMinesweeperButtonClicked());
        view.getHexagonalMinesweeperButton().addActionListener(e -> playHexagonalMinesweeperButtonClicked());
        view.getColouringProblemMinesweeperButton().addActionListener(e -> playColouringProblemMinesweeperButtonClicked());
    }

    // Handles creating a new minesweeper game.
    private void playMinesweeperButtonClicked() {
        if (!isAGameRunning) {
            isAGameRunning = true;
            minefield = new Minefield(9, Difficulty.BEGINNER);
            minefield.callback = this;
            initiateMinesweeperGrid();
        } else {
            handleAlreadyGameRunning(promptUser());
        }
    }
    
    // Handles creating a new hexagonal minesweeper game.
    private void playHexagonalMinesweeperButtonClicked() {
        JOptionPane.showConfirmDialog(null, "Game mode currently not implemented", "Not Implemented", JOptionPane.OK_OPTION);
    }
    
    // Handles creating a new colouring problem minesweeper game.
    private void playColouringProblemMinesweeperButtonClicked() {
        JOptionPane.showConfirmDialog(null, "Game mode currently not implemented", "Not Implemented", JOptionPane.OK_OPTION);
    }

    // Handles the selection of the user when a game is already in progress.
    private void handleAlreadyGameRunning(int optionSelected) {
        if (optionSelected == 0) {
            gameOver();
        }
    }

    // Notifies the user that a game is in progress.
    private int promptUser() {
        return JOptionPane.showConfirmDialog(null, "A game is currently in progress.\nDo you want to stop current game.",
                "Game Running", JOptionPane.YES_NO_OPTION);
    }

    // Instantiates the minesweeper grid tiles and sets the action listeners.
    private void initiateMinesweeperGrid() {
        view.instantiateMinesweeperGrid(minefield.getGridLength());
        for (int x = 0; x < minefield.getGridLength(); x++) {
            for (int y = 0; y < minefield.getGridLength(); y++) {
                view.instantiateTiles(x, y);
                view.getMinesweeperGridTile(x, y).addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        minesweeperGridTileClicked(e);
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {

                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {

                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {

                    }

                    @Override
                    public void mouseExited(MouseEvent e) {

                    }
                });
                view.addTileToGrid(x, y);
            }
        }
        view.repaintMinesweeperGrid();
    }

    // Handles the selection of minesweeper grid tiles.
    private void minesweeperGridTileClicked(MouseEvent e) {
        for (int x = 0; x < minefield.getGridLength(); x++) {
            for (int y = 0; y < minefield.getGridLength(); y++) {
                if (view.getMinesweeperGridTile(x, y) == e.getSource()) {
                    if (e.getButton() == 3 || e.getModifiersEx() == 64) {
                        minefield.selectTile(x, y, true);
                    } else {
                        minefield.selectTile(x, y, false);
                    }
                }
            }
        }
    }

    /**
     * Flags a tile preventing it from being revealed.
     *
     * @param x - The position of the tile on the grids x axis.
     * @param y - The position of the tile on the grids y axis.
     
    private void flagTile(int x, int y) {
        Tile tile = minefield.getTile(x, y);
        JButton gridTile = view.getMinesweeperGridTile(x, y);
        tile.flagTile();
        if (tile.isTileFlagged()) {
            gridTile.setText("F");
        } else {
            gridTile.setText("");
        }
    }*/

    // Handles tile selection
    /*private void selectTile(int x, int y) {
        JButton gridTile = view.getMinesweeperGridTile(x, y);
        Tile tile = minefield.getTile(x, y);
        if (!tile.isTileFlagged()) {
            gridTile.setEnabled(false);
            if (tile.isMineTile()) {
                gridTile.setText("B");
                //endGame();
            } else if (tile.getAdjacentMineCount() == 0 && !tile.isTileRevealed()) {
                minefield.selectTile(x, y);
            } else {
                gridTile.setText(String.format("%s", tile.getAdjacentMineCount() == 0 ? "" : tile.getAdjacentMineCount()));
                tile.revealTile();
            }
        }
    }*/

    // Ends the game when a mine is selected.
    private void gameOver() {
        isAGameRunning = false;
        revealGrid();
        // resetTimer();
        //deconstructGrid();
    }
    
    private void revealGrid() {
        minefield.revealMinefield();
    }

    private void deconstructGrid() {
        view.deconstructGrid();
    }

    // If a tile has no adjacent mines then neighbouring tiles are revealed.
    /*private void revealEmptyTiles(int x, int y) {
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (i > - 1 && i < minefield.getGridLength() && j > - 1 && j < minefield.getGridLength()) {
                    selectTile(i, j);
                }
            }
        }
    }*/
}
