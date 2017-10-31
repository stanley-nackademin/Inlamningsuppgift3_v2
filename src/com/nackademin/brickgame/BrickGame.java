package com.nackademin.brickgame;

import javax.swing.*;
import java.awt.*;

public class BrickGame extends JFrame {

    BrickGame() {
        this.setTitle("Brick matching game");
        this.setPreferredSize(new Dimension(500, 500));
        this.setResizable(false);
        this.setContentPane(new GUI());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        BrickGame m = new BrickGame();
    }
}
