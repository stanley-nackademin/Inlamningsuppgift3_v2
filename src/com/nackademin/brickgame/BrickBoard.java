package com.nackademin.brickgame;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class BrickBoard extends JPanel {
    protected final static int ROW = 4;
    protected final static int COLUMN = 4;
    private Brick[][] board;
    private Brick[][] solutionBoard;
    protected Brick[][] testBoard;
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

        testBoard = new Brick[ROW][COLUMN];
        int counter2 = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                testBoard[i][j] = new Brick(Values.values()[counter2], i, j);
                counter2++;
            }
        }
    }

    public void shuffle() {
        // Setup a new board
        int counter = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                board[i][j] = new Brick(Values.values()[counter], i, j);
                counter++;
            }
        }
        // Set the last brick to null because it's an empty space
        //board[ROW - 1][COLUMN - 1] = null;

        // Shuffles the board
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                exchangeBricks(i, j, (int)(Math.random() * ROW), (int)(Math.random() * COLUMN));
                //System.out.println(board[i][j]);
            }
        }
    }

    private void exchangeBricks(int row, int column, int row2, int column2) {
        int tempX, tempY;

        Values tempValue = board[row][column].getValue();
        board[row][column].setValue(board[row2][column2].getValue());
        board[row2][column2].setValue(tempValue);

        /*// Temporarily store the first brick and its positions
        Brick temp = board[row][column];
        tempX = temp.getPosX();
        tempY = temp.getPosY();
        // Set the temporary brick's positions from the second brick
        temp.setPosX(board[row2][column2].getPosX());
        temp.setPosY(board[row2][column2].getPosY());
        // Move the second brick's place to the first brick
        board[row][column] = board[row2][column2];
        // Set the temporarily stored positions to the moved brick
        board[row][column].setPosX(tempX);
        board[row][column].setPosY(tempY);
        // Move the first brick's place to the second brick
        board[row2][column2] = temp;*/
    }

    public boolean moveBrick(Brick brick) {
        int x = brick.getPosX();
        int y = brick.getPosY();

        if (isValidMovement(x, y, -1, 0)) {
            if (isEmpty(x, y, -1, 0)) {
                exchangeBricks(brick.getPosX(), brick.getPosY(), brick.getPosX() - 1, brick.getPosY());
                return true;
            }
        }
        if (isValidMovement(x, y, 1, 0)) {
            if (isEmpty(x, y, 1, 0)) {
                exchangeBricks(brick.getPosX(), brick.getPosY(), brick.getPosX() + 1, brick.getPosY());
                return true;
            }
        }
        if (isValidMovement(x, y, 0, -1)) {
            if (isEmpty(x, y, 0, -1)) {
                exchangeBricks(brick.getPosX(), brick.getPosY(), brick.getPosX(), brick.getPosY() - 1);
                return true;
            }
        }
        if (isValidMovement(x, y, 0, 1)) {
            if (isEmpty(x, y, 0, 1)) {
                exchangeBricks(brick.getPosX(), brick.getPosY(), brick.getPosX(), brick.getPosY() + 1);
                return true;
            }
        }
        return false;
    }

    private boolean isValidMovement(int x, int y, int xDelta, int yDelta) {
        return x + xDelta >= 0 && x + xDelta < ROW && y + yDelta >= 0 && y + yDelta < COLUMN;
    }

    private boolean isEmpty(int x, int y, int xDelta, int yDelta) {
        Brick b = getBoard()[x + xDelta][y + yDelta];
        return b.getValue().getValue() == 0;
    }

    public boolean checkSolution(Brick[][] board) {
        Brick b1, b2;

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COLUMN; j++) {
                b1 = board[i][j];
                b2 = solutionBoard[i][j];
                if (!(b1.getValue() == b2.getValue())) {
                    return false;
                }
            }
        }
        return true;
    }
}
