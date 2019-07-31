/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author brendon
 */
public class Controller implements Callback {

    private ApplicationView view;
    private Minefield minefield;
    private boolean isAGameRunning = false;
    private boolean isTimerRunning = false;
    private Timer timer;

    public Controller(ApplicationView view) {
        this.view = view;
        setupSideBarButtons();
    }

    public void flagTile(int xPosition, int yPosition) {
        view.flagTile(xPosition, yPosition);
    }

    public void displayTile(int xPosition, int yPosition, String label) {
        view.revealTile(xPosition, yPosition, label);
    }

    public void gameOver(boolean didWin) {
        stopGameTimer();
        isAGameRunning = false;
        String message = didWin ? "Congratulations, You've Won!\nPlay Again?" : "BANG, You've Lost!\nPlay Again?";
        String title = didWin ? "Winner" : "Loser";
        promptUserWithOutcome(message, title);
    }
    
    private void promptUserWithOutcome(String message, String title) {
        int selectedOption = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (selectedOption >= 0) {
            view.deconstructGrid();
            if (selectedOption == 0)
                promptUserForGameDifficulty();
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
            promptUserForGameDifficulty();
        } else {
            handleGameRunning(promptUser());
        }
    }
    
    private void promptUserForGameDifficulty() {
        int selection = JOptionPane.showConfirmDialog(null, view.getDifficultySelectionPanel(),
                "Select Difficulty", JOptionPane.OK_CANCEL_OPTION);
        if (selection == 0) {
            initiateMinesweeperGrid(getGameDifficulty(view.getSelectedDifficulty()));
        }
    }
    
    private Difficulty getGameDifficulty(String difficulty) {
        switch (difficulty) {
            case "Beginner" : return Difficulty.BEGINNER;
            case "Intermediate" : return Difficulty.INTERMEDIATE;
            case "Expert" : return Difficulty.EXPERT;
        }
        return Difficulty.NONE;
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
    private void handleGameRunning(int optionSelected) {
        if (optionSelected == 0) {
            isAGameRunning = false;
            view.deconstructGrid();
            minefield.revealMinefield();
        }
    }

    // Notifies the user that a game is in progress.
    private int promptUser() {
        return JOptionPane.showConfirmDialog(null, "A game is currently in progress.\nDo you want to stop current game.",
                "Game Running", JOptionPane.YES_NO_OPTION);
    }

    // Instantiates the minesweeper grid tiles and sets the action listeners.
    private void initiateMinesweeperGrid(Difficulty difficulty) {
        isAGameRunning = true;
        minefield = new Minefield(difficulty);
        minefield.callback = this;
        view.instantiateMinesweeperGrid(minefield.getGridWidth(), minefield.getGridHeight());
        for (int x = 0; x < minefield.getGridWidth(); x++) {
            for (int y = 0; y < minefield.getGridHeight(); y++) {
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
            }
        }
    }

    // Handles the selection of minesweeper grid tiles.
    private void minesweeperGridTileClicked(MouseEvent e) {
        if (!isTimerRunning) {
            isTimerRunning = true;
            startGameTimer();
        }
        for (int x = 0; x < minefield.getGridWidth(); x++) {
            for (int y = 0; y < minefield.getGridHeight(); y++) {
                if (view.getMinesweeperGridTile(x, y) == e.getSource()) {
                    minefield.selectTile(x, y, e.getButton() == 3);
                }
            }
        }
    }

    private void startGameTimer() {
        timer = new Timer();
        new Thread(new Runnable() {
            int time = 0;

            @Override
            public void run() {
                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        time++;
                        view.setScoreLabel(time);
                    }
                }, 0, 1000);
            }
        }).start();
    }

    private void stopGameTimer() {
        isTimerRunning = false;
        timer.cancel();
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
