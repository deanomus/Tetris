package de.deanomus.tetris.util;

import java.util.Random;

public class Helper {

    public static String ArrayToString(int[][] array) {
        String out = "";
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                out += array[i][j];
                if (j != array[i].length - 1) out += ", ";
            }
            out += "\n";
        }
        return out;
    }

    public static int[][] rotateArray(int[][] Array) {
        int[][] newArray = new int[Array.length][Array[0].length];
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array.length; j++) {
                newArray[j][Array.length - 1 - i] = Array[i][j];
            }
        }

        return newArray;
    }

    public static int[][] rotateArray(int Times, int[][] Array) {
        if (Times <= 0) return Array;

        int[][] newArray = new int[Array.length][Array[0].length];
        for (int i = 0; i < Array.length; i++) {
            for (int j = 0; j < Array[0].length; j++) {
                newArray[i][j] = Array[i][j];
            }
        }

        for (int i = 0; i < Times; i++) {
            newArray = rotateArray(newArray);
        }
        return newArray;
    }


    public static int rdmInt(int min, int max) {
        Random r = new Random();
        int genInt = r.nextInt((max - min) + 1) + min;
        return genInt;
    }

    public static int NegativePositiveChange(int i) {
        if (i == 0) return i;

        if (i < 0) {
            return Math.abs(i);
        }

        if (i > 0) {
            return (i - (i * 2));
        }
        return 0;
    }

}
