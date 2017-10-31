package com.nackademin.brickgame;

import javax.swing.*;
import java.util.List;

public class BrickBoard extends JPanel {
    protected final static int ROW = 4;
    protected final static int COLUMN = 4;
    private Brick[][] board;
    private Brick[][] solutionBoard;
    /*private List<Brick> brickList;

    public List<Brick> getBrickList() {
        return brickList;
    }

    public void setBrickList(List<Brick> brickList) {
        this.brickList = brickList;
    }*/

    public Brick[][] getBoard() {
        return board;
    }

    // Constructor
    BrickBoard() {
        board = new Brick[ROW][COLUMN];
        shuffle();

        // Create solution board to compare with
        solutionBoard = new Brick[ROW][COLUMN];
        int counter = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                solutionBoard[i][j] = new Brick(Values.values()[counter], i, j);
                counter++;
            }
        }
    }

    public void shuffle() {
        int counter = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                board[i][j] = new Brick(Values.values()[counter], i, j);
                counter++;
            }
        }
        // Set the last brick to null because it's an empty space
        //board[ROW - 1][COLUMN - 1] = null;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                exchangeBricks(i, j, (int)(Math.random() * ROW), (int)(Math.random() * COLUMN));
                //System.out.println(board[i][j]);
            }
        }
    }

    public void exchangeBricks(int row, int column, int row2, int column2) {
        Brick temp = board[row][column];
        board[row][column] = board[row2][column2];
        board[row2][column2] = temp;
    }
}
