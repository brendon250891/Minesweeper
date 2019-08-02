/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author brendon
 */
public class ApplicationView {

    private javax.swing.JFrame applicationFrame;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel currentScoreLabel;
    private javax.swing.JPanel sideBarPanel;
    private javax.swing.JPanel titleBarPanel;
    private javax.swing.JPanel minesweeperGrid;
    private javax.swing.JButton playColourProblemMinesweeperButton;
    private javax.swing.JButton playHexagonalMinesweeperButton;
    private javax.swing.JButton playMinesweeperButton;
    private javax.swing.JButton[][] tiles;
    private javax.swing.JPanel difficultySelectionPanel;
    private javax.swing.ButtonGroup radioButtonGroup;

    public ApplicationView() {
        applicationFrame = new javax.swing.JFrame();
        titleBarPanel = new javax.swing.JPanel();
        scoreLabel = new javax.swing.JLabel();
        currentScoreLabel = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        sideBarPanel = new javax.swing.JPanel();
        playMinesweeperButton = new javax.swing.JButton();
        playHexagonalMinesweeperButton = new javax.swing.JButton();
        playColourProblemMinesweeperButton = new javax.swing.JButton();
        minesweeperGrid = new javax.swing.JPanel();
        minesweeperGrid.setVisible(false);
        difficultySelectionPanel = new javax.swing.JPanel();

        applicationFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        applicationFrame.setTitle("Minesweeper");
        applicationFrame.setBackground(new java.awt.Color(255, 255, 255));
        applicationFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        titleBarPanel.setBackground(new java.awt.Color(0, 51, 51));
        titleBarPanel.setPreferredSize(new java.awt.Dimension(806, 80));

        scoreLabel.setBackground(new java.awt.Color(255, 255, 255));
        scoreLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setText("Score:");

        currentScoreLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        currentScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        currentScoreLabel.setText("0");
        
        javax.swing.JRadioButton beginnerButton = new javax.swing.JRadioButton("Beginner", true);
        javax.swing.JRadioButton intermediateButton = new javax.swing.JRadioButton("Intermediate");
        javax.swing.JRadioButton expertButton = new javax.swing.JRadioButton("Expert");
        
        beginnerButton.setActionCommand("Beginner");
        intermediateButton.setActionCommand("Intermediate");
        expertButton.setActionCommand("Expert");
        
        radioButtonGroup = new javax.swing.ButtonGroup();
        radioButtonGroup.add(beginnerButton);
        radioButtonGroup.add(intermediateButton);
        radioButtonGroup.add(expertButton);
        
        difficultySelectionPanel.setLayout(new java.awt.GridLayout(3, 0));
        difficultySelectionPanel.add(beginnerButton);
        difficultySelectionPanel.add(intermediateButton);
        difficultySelectionPanel.add(expertButton);
        difficultySelectionPanel.revalidate();
        

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(titleBarPanel);
        titleBarPanel.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scoreLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(currentScoreLabel)
                                .addGap(397, 397, 397))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(scoreLabel)
                                        .addComponent(currentScoreLabel))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        backgroundPanel.setBackground(new java.awt.Color(153, 153, 153));
        minesweeperGrid.setBackground(new java.awt.Color(153, 153, 153));

        sideBarPanel.setBackground(new java.awt.Color(0, 51, 51));
        sideBarPanel.setPreferredSize(new java.awt.Dimension(160, 514));

        playMinesweeperButton.setBackground(new java.awt.Color(255, 255, 255));
        playMinesweeperButton.setText("Minesweeper");
        playMinesweeperButton.setPreferredSize(new java.awt.Dimension(125, 80));

        playHexagonalMinesweeperButton.setBackground(new java.awt.Color(255, 255, 255));
        playHexagonalMinesweeperButton.setText("Hexagonal");
        playHexagonalMinesweeperButton.setPreferredSize(new java.awt.Dimension(125, 80));

        playColourProblemMinesweeperButton.setBackground(new java.awt.Color(255, 255, 255));
        playColourProblemMinesweeperButton.setText("Colour Problem");
        playColourProblemMinesweeperButton.setPreferredSize(new java.awt.Dimension(125, 80));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(sideBarPanel);
        sideBarPanel.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(playMinesweeperButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playHexagonalMinesweeperButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(playColourProblemMinesweeperButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(playMinesweeperButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(playHexagonalMinesweeperButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(playColourProblemMinesweeperButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        minesweeperGrid.setLayout(new java.awt.GridLayout(9, 9, -4, -4));

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addComponent(sideBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(minesweeperGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sideBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(minesweeperGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(applicationFrame.getContentPane());
        applicationFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(titleBarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(titleBarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        applicationFrame.pack();
        applicationFrame.setLocationRelativeTo(null);
        applicationFrame.setVisible(true);
    }
    
    /**
     * Gets the playMinesweeperButton.
     * @return - The playMinesweeperButton.
     */
    public javax.swing.JButton getPlayMinesweeperButton() {
        return this.playMinesweeperButton;
    }
    
    /**
     * Gets the playHexagonalMinesweeperButton.
     * @return - The playHexagonalMinesweeperButton.
     */
    public javax.swing.JButton getHexagonalMinesweeperButton() {
        return this.playHexagonalMinesweeperButton;
    }
    /**
     * Gets the playColouringProblemMinesweeperButton.
     * @return - The playColouringProblemMinesweeperButton.
     */
    public javax.swing.JButton getColouringProblemMinesweeperButton() {
        return this.playColourProblemMinesweeperButton;
    }
    
    /**
     * Gets the difficulySelectinPanel
     * @return - The difficultySelectionPanel.
     */
    public javax.swing.JPanel getDifficultySelectionPanel() {
        return this.difficultySelectionPanel;
    }
    
    /**
     * Gets the difficulty that the player has chosen.
     * @return - The text of the radio button of difficulty chosen.
     */
    public String getSelectedDifficulty() {
        return this.radioButtonGroup.getSelection().getActionCommand();
    }
    
    /**
     * Gets the minesweeperGrid.
     * @return - The minesweeperGrid.
     */
    public javax.swing.JPanel getMinesweeperGrid() {
        return this.minesweeperGrid;
    }
    
    /**
     * Instantiates a new minesweeperGrid based on the given dimensions.
     * @param gridWidth - The width of the Minefield.
     * @param gridHeight - The height of the Minefield.
     */
    public void instantiateMinesweeperGrid(int gridWidth, int gridHeight) {
        minesweeperGrid.setLayout(new java.awt.GridLayout(gridWidth, gridHeight, -5, -5));
        tiles = new javax.swing.JButton[gridWidth][gridHeight];
    }
    
    /**
     * Instantiates the Tiles of the Minefield.
     * @param x - The x axis of the Tile in the Minefield.
     * @param y - The y axis of the Tile in the Minefield.
     */
    public void instantiateTiles(int x, int y) {
        javax.swing.JButton tile = new javax.swing.JButton();
        tile.setFont(new Font("Lucinda Grande", Font.PLAIN, 36));
        tile.setPreferredSize(new java.awt.Dimension(35, 35));
        tiles[x][y] = tile;
        minesweeperGrid.add(tile);
        repaintMinesweeperGrid();
    }
    
    /**
     * Gets the Tile at the given x and y positions.
     * @param x - The x axis position of the Tile in the Minefield.
     * @param y - The y axis position of the TIle in the Minefield.
     * @return 
     */
    public javax.swing.JButton getMinesweeperGridTile(int x, int y) {
        return tiles[x][y];
    }
    
    /**
     * Reveals the Tile at the given x and y positions with the label.
     * @param xPosition - The x axis position of the Tile in the Minefield.
     * @param yPosition - The y axis position of the Tile in the Minefield.
     * @param label - The label to set the Tile's text to.
     */
    public void revealTile(int xPosition, int yPosition, String label) {
        javax.swing.JButton tile = tiles[xPosition][yPosition];
        tile.setText(label);
        tile.setEnabled(false);
    }
    
    /**
     * Flags the Tile at the given x and y positions.
     * @param xPosition - The x axis position of the Tile in the Minefield.
     * @param yPosition - The y axis position of the Tile in the Minefield.
     */
    public void flagTile(int xPosition, int yPosition) {
        tiles[xPosition][yPosition].setText(tiles[xPosition][yPosition].getText().equalsIgnoreCase("f") ? "" : "F");
    }
    
    /**
     * Deconstructs the current Minefield.
     */
    public void deconstructGrid() {
        minesweeperGrid.removeAll();
        minesweeperGrid.setVisible(false);
        setScoreLabel("0");
    }
    
    /**
     * Repaints the Minefield.
     */
    public void repaintMinesweeperGrid() {
        minesweeperGrid.setVisible(true);
        minesweeperGrid.revalidate();
        minesweeperGrid.repaint();
        setScoreLabel("0");
    }
    
    /**
     * Sets the score label based on the current timer.
     * @param time - The time to set the text to.
     */
    public void setScoreLabel(String time) {
        currentScoreLabel.setText(time);
    }
    
    /**
     * Gets a colour to set the text of revealed Tiles based on the adjacent mine count.
     * @param mineCount - The Tile's adjacent mine count.
     * @return - A Color based on mine count.
     */
    private Color getTileTextColour(int mineCount) {
                switch (mineCount) {
            case 1:
                return Color.BLUE;
            case 2:
                return Color.CYAN;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.MAGENTA;
            case 5:
                return Color.ORANGE;
            case 6:
                return Color.PINK;
            case 7:
                return Color.RED;
            case 8:
                return Color.YELLOW;
        }
        return Color.RED;
    }
}
