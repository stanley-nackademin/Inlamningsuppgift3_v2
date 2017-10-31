package com.nackademin.brickgame;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    BrickBoard board;

    GUI() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;

        // Board panel
        board = new BrickBoard();
        board.setLayout(new GridLayout(4, 4));
        this.add(board, c);

        // Add bricks to board
        for (int i = 0; i < board.ROW; i++) {
            for (int j = 0; j < board.COLUMN; j++) {
                board.add(board.getBoard()[i][j]);
            }
        }

        // Bottom panel
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JButton newGameButton = new JButton("Nytt spel");
        newGameButton.addActionListener(ae -> newGame());
        bottomPanel.add(newGameButton);
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 1;
        this.add(bottomPanel, c);
    }

    public void newGame() {
        System.out.println("Nytt spel klickades");
        board.shuffle();
        board.removeAll();
        for (int i = 0; i < board.ROW; i++) {
            for (int j = 0; j < board.COLUMN; j++) {
                board.add(board.getBoard()[i][j]);
            }
        }
        board.revalidate();
        board.repaint();
    }
}
