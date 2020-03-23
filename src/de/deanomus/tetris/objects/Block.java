package de.deanomus.tetris.objects;

import de.deanomus.tetris.util.Helper;

import java.awt.*;
import java.util.Arrays;

public class Block {

    private int[][] ib;
    private Color color;

    public Block() {
    }

    protected void setup(int[][] ib, Color color) {
        this.ib = ib;
        this.color = color;
    }

    @Override
    public String toString() {

        return Helper.ArrayToString(ib);
    }


    public void rotate(int times) {

    }


}
