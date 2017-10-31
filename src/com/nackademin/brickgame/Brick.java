package com.nackademin.brickgame;

import javax.swing.*;
import java.awt.*;

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
        this.setText(value.toString());
        this.setPreferredSize(new Dimension(100, 100));
        this.setFont(new Font("Arial", Font.PLAIN, 20));
    }

    @Override
    public String toString() {
        return "Brick value is: " + value.getValue() +
                "\nPositions is x: " + posX + " y: " + posY;
    }
}
