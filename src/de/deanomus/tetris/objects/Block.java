package de.deanomus.tetris.objects;

import de.deanomus.tetris.util.Helper;

import java.awt.*;
import java.util.Arrays;

public class Block {

    protected int[][] ib;
    protected Color color;

    public Block() {
    }

    @Override
    public String toString() {
        String out = "First:\n";
        out += Helper.ArrayToString(ib);

        out += "\nSecond:\n";
        out += Helper.ArrayToString(Helper.rotateArray(0, ib));
        return out;
    }


    public void rotate(int times) {
        ib = Helper.rotateArray(times, ib);
    }


}
