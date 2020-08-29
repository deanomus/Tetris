package de.deanomus.tetris.util;

public class Conversion {

    public static int celltoCoord(int cell) {
        return cell * 32;
    }


    public static int coordToCell(int coord) {
        return coord / 32;
    }

}
