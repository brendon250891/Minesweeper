/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.Color;
import java.awt.Font;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author brendon
 */
public class ApplicationView {

    private javax.swing.JFrame applicationFrame;
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel minesweeperGrid;
    private javax.swing.JButton playColourProblemMinesweeperButton;
    private javax.swing.JButton playHexagonalMinesweeperButton;
    private javax.swing.JButton playMinesweeperButton;
    private javax.swing.JButton[][] tiles;

    public ApplicationView() {
        applicationFrame = new javax.swing.JFrame();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        playMinesweeperButton = new javax.swing.JButton();
        playHexagonalMinesweeperButton = new javax.swing.JButton();
        playColourProblemMinesweeperButton = new javax.swing.JButton();
        minesweeperGrid = new javax.swing.JPanel();
        minesweeperGrid.setVisible(false);

        applicationFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        applicationFrame.setTitle("Minesweeper");
        applicationFrame.setBackground(new java.awt.Color(255, 255, 255));
        applicationFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(0, 51, 51));
        jPanel3.setPreferredSize(new java.awt.Dimension(806, 80));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Score:");

        scoreLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scoreLabel)
                                .addGap(397, 397, 397))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(scoreLabel))
                                .addContainerGap(18, Short.MAX_VALUE))
        );

        backgroundPanel.setBackground(new java.awt.Color(153, 153, 153));
        minesweeperGrid.setBackground(new java.awt.Color(153, 153, 153));

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 514));

        playMinesweeperButton.setBackground(new java.awt.Color(255, 255, 255));
        playMinesweeperButton.setText("Minesweeper");
        playMinesweeperButton.setPreferredSize(new java.awt.Dimension(125, 80));

        playHexagonalMinesweeperButton.setBackground(new java.awt.Color(255, 255, 255));
        playHexagonalMinesweeperButton.setText("Hexagonal");
        playHexagonalMinesweeperButton.setPreferredSize(new java.awt.Dimension(125, 80));

        playColourProblemMinesweeperButton.setBackground(new java.awt.Color(255, 255, 255));
        playColourProblemMinesweeperButton.setText("Colour Problem");
        playColourProblemMinesweeperButton.setPreferredSize(new java.awt.Dimension(125, 80));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
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
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addComponent(minesweeperGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 759, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 16, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                                .addContainerGap(10, Short.MAX_VALUE)
                                .addComponent(minesweeperGrid, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(applicationFrame.getContentPane());
        applicationFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 941, Short.MAX_VALUE)
                        .addComponent(backgroundPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        applicationFrame.pack();
        applicationFrame.setLocationRelativeTo(null);
        applicationFrame.setVisible(true);
    }
    
    // Returns the play minesweeper button.
    public javax.swing.JButton getPlayMinesweeperButton() {
        return this.playMinesweeperButton;
    }
    
    public javax.swing.JButton getHexagonalMinesweeperButton() {
        return this.playHexagonalMinesweeperButton;
    }
    
    public javax.swing.JButton getColouringProblemMinesweeperButton() {
        return this.playColourProblemMinesweeperButton;
    }
    
    // Returns the minesweeper grid.
    public javax.swing.JPanel getMinesweeperGrid() {
        return this.minesweeperGrid;
    }
    
    // Instantiates the minesweeper grid.
    public void instantiateMinesweeperGrid(int gridLength) {
        tiles = new javax.swing.JButton[gridLength][gridLength];
    }
    
    // Instantiates minesweeper grid tiles.
    public void instantiateTiles(int x, int y) {
        tiles[x][y] = new javax.swing.JButton();
        tiles[x][y].setFont(new Font("Lucinda Grande", Font.PLAIN, 36));
        minesweeperGrid.add(tiles[x][y]);
        repaintMinesweeperGrid();
    }
    
    // Returns a minesweeper grid tile.
    public javax.swing.JButton getMinesweeperGridTile(int x, int y) {
        return tiles[x][y];
    }
    
    public void revealTile(int xPosition, int yPosition, String label) {
        javax.swing.JButton tile = tiles[xPosition][yPosition];
        tile.setText(label);
        tile.setEnabled(false);
    }
    
    public void flagTile(int xPosition, int yPosition) {
        tiles[xPosition][yPosition].setText(tiles[xPosition][yPosition].getText().equalsIgnoreCase("f") ? "" : "F");
    }
    
    public void deconstructGrid() {
        minesweeperGrid.removeAll();
        minesweeperGrid.setVisible(false);
        setScoreLabel(0);
    }
    
    // Repaints the minesweeper grid.
    public void repaintMinesweeperGrid() {
        minesweeperGrid.setVisible(true);
        minesweeperGrid.revalidate();
        minesweeperGrid.repaint();
        setScoreLabel(0);
    }
    
    public void setScoreLabel(int time) {
        scoreLabel.setText(Integer.toString(time));
    }
    
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
