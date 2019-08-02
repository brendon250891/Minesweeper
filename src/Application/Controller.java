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
 * Communicates player interaction with the View to be reflected in the Model.
 * @author brendon
 */
public class Controller implements Callback {
    // The view of the application.
    private ApplicationView view;
    
    // The Minefield of the current game if one is runnnig.
    private Minefield minefield;
    
    // Flag to indicate if a game is running.
    private boolean isAGameRunning = false;
    
    // Flag to indicate if the timer is running
    private boolean isTimerRunning = false;
    
    // The timer for the current game.
    private Timer timer;

    /**
     * The default constructor
     * @param view - The applications View instance.
     */
    public Controller(ApplicationView view) {
        this.view = view;
        setupSideBarButtons();
    }

    /**
     * Interface method to flag a tile on the view.
     * @param tile - The Tile to flag.
     */
    @Override
    public void flagTile(Tile tile) {
        view.flagTile(tile.getXPosition(), tile.getYPosition());
    }
    
    /**
     * Interface method to display a selected tile.
     * @param tile - The Tile to display it's label.
     */
    @Override
    public void displayTile(Tile tile) {
        view.revealTile(tile.getXPosition(), tile.getYPosition(), tile.getTileLabel());
    }

    /**
     * Interface method to end a game when a outcome has been reached.
     * @param didWin - true if the player won.
     */
    @Override
    public void gameOver(boolean didWin) {
        stopGameTimer();
        String message = didWin ? "Congratulations, You've Won!\nPlay Again?" : "BANG, You've Lost!\nPlay Again?";
        String title = didWin ? "Winner" : "Loser";
        promptUserWithOutcome(message, title);
    }
    
    /**
     * Prompts the user with a confirm dialog indicating the outcome of the current game.
     * @param message - The message to display.
     * @param title - The title of the dialog box.
     */
    private void promptUserWithOutcome(String message, String title) {
        int selectedOption = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        if (selectedOption >= 0) {
            this.stopGameTimer();
            view.deconstructGrid();
            if (selectedOption == 0)
                promptUserForGameDifficulty();
        }
    }
    
    /**
     * Prompts the user if they try to start a game when one is currently running.
     * @param message - The message to display.
     * @param title  - The title of the dialog box.
     */
    private void promptUserRunningGame(String message, String title) {
        if (JOptionPane.showConfirmDialog(null, message, title, JOptionPane.OK_CANCEL_OPTION) == 0) {
            this.stopGameTimer();
            view.deconstructGrid();
        }
    }

    /**
     * Sets up the left side panel play game buttons action listeners.
     */
    private void setupSideBarButtons() {
        view.getPlayMinesweeperButton().addActionListener(e -> playMinesweeperButtonClicked());
        view.getHexagonalMinesweeperButton().addActionListener(e -> playHexagonalMinesweeperButtonClicked());
        view.getColouringProblemMinesweeperButton().addActionListener(e -> playColouringProblemMinesweeperButtonClicked());
    }

    /**
     * Handles the clicking of the play minesweeper button.
     */
    private void playMinesweeperButtonClicked() {
        if (!isAGameRunning) {
            promptUserForGameDifficulty();
        } else {
            promptUserRunningGame("Do You Want To End Current Game", "Game in Progress");
        }
    }
    
    /**
     * Prompts the user to select what game difficulty they wish to play.
     */
    private void promptUserForGameDifficulty() {
        int selection = JOptionPane.showConfirmDialog(null, view.getDifficultySelectionPanel(),
                "Select Difficulty", JOptionPane.OK_CANCEL_OPTION);
        if (selection == 0) {
            initiateMinesweeperGrid(getGameDifficulty(view.getSelectedDifficulty()));
        }
    }
    
    /**
     * Gets the selected game difficulty based on the players selection.
     * @param difficulty - The text of the radio button selected.
     * @return 
     */
    private Difficulty getGameDifficulty(String difficulty) {
        switch (difficulty) {
            case "Beginner" : return Difficulty.BEGINNER;
            case "Intermediate" : return Difficulty.INTERMEDIATE;
            case "Expert" : return Difficulty.EXPERT;
        }
        return Difficulty.NONE;
    }

    /**
     * Handles the clicking of the play hexagonal minesweeper button.
     */
    private void playHexagonalMinesweeperButtonClicked() {
        JOptionPane.showMessageDialog(null, "Game mode currently not implemented", "Not Implemented", JOptionPane.OK_OPTION);
    }

    /**
     * Handles the click of the play colouring problem minesweeper button.
     */
    private void playColouringProblemMinesweeperButtonClicked() {
        JOptionPane.showMessageDialog(null, "Game mode currently not implemented", "Not Implemented", JOptionPane.OK_OPTION);
    }

    /**
     * Instantiates the Minefield based on the settings selected.
     * @param difficulty - The difficulty to set the game to.
     */
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

    /**
     * Handles the selection of a Tile in the view.
     * @param e  - The mouse event triggered.
     */
    private void minesweeperGridTileClicked(MouseEvent e) {
        if (!isTimerRunning) {
            isTimerRunning = true;
            startGameTimer();
        }
        for (int x = 0; x < minefield.getGridWidth(); x++) {
            for (int y = 0; y < minefield.getGridHeight(); y++) {
                if (view.getMinesweeperGridTile(x, y) == e.getSource()) {
                    minefield.selectTile(minefield.getTile(x, y), e.getButton() == 3);
                }
            }
        }
    }

    /**
     * Starts the games timer when the first Tile is selected.
     */
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
                        view.setScoreLabel(Integer.toString(time));
                    }
                }, 0, 1000);
            }
        }).start();
    }

    /**
     * Stops the games timer when a outcome is reached.
     */
    private void stopGameTimer() {
        isAGameRunning = false;
        isTimerRunning = false;
        timer.cancel();
    }
}
