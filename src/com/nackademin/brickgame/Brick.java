package com.nackademin.brickgame;

import javax.swing.*;

public class Brick extends JButton {
    private Values value;
    private int posX;
    private int posY;

    public Values getValue() {
        return value;
    }

    public void setValue(Values value) {
        this.value = value;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    Brick(Values value, int posX, int posY) {
        this.value = value;
        this.posX = posX;
        this.posY = posY;
    }

    @Override
    public String toString() {
        return "Brick value is: " + value.getValue() +
                "Positions is x: " + posX + " y: " + posY;
    }
}
