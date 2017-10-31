package com.nackademin.brickgame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BrickGame extends JFrame {

    BrickGame() {
        this.setTitle("Brick matching game");
        this.setContentPane(new GUI());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

















        /*List<Brick> brickList = new ArrayList<>();

        int counter = 0;
        for (int i = 0; i < BrickBoard.ROW; i++) {
            for (int j = 0; j < BrickBoard.COLUMN; j++) {
                Brick b = new Brick(Values.values()[counter],
                        new Position(i, j));
                brickList.add(b);
                counter++;
            }
        }

        BrickBoard board = new BrickBoard(brickList);



        JPanel topPanel = new JPanel(new GridLayout(4, 4));
        this.add(topPanel);
        for (Brick b : board.getBrickList()) {
            b.setText(b.getValue().toString());
            topPanel.add(b);
        }




        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);*/
    }

    public static void main(String[] args) {
        BrickGame m = new BrickGame();
    }
}
