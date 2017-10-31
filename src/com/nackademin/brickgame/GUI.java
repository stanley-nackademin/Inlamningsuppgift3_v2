package com.nackademin.brickgame;

import javax.swing.*;
import java.awt.*;

public class GUI extends JPanel {

    BrickBoard board;

    GUI() {
        this.setLayout(new GridLayout(2, 1));
        board = new BrickBoard();
        this.add(board);

        JButton newGameButton = new JButton("Nytt spel");
        newGameButton.addActionListener(ae -> newGame());
        this.add(newGameButton);
    }

    public void newGame() {
        System.out.println("Nytt spel klickades");
    }
}
