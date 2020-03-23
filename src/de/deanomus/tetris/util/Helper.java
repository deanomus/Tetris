package de.deanomus.tetris.util;

public class Helper {

    public static String ArrayToString(int[][] array) {
        String out = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                out += array[i][j];
                if(j != array[i].length-1) out += ", ";
            }
            out += "\n";
        }
        return out;
    }

}
