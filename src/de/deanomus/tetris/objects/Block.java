package de.deanomus.tetris.objects;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Block {

    BlockType type;
    private int x, y, size,
            rotation = 0;
    private int[][][] bounds;
    Color color;
    boolean moveable = true;

    public Block() {
        type = BlockType.rdm();
        switch (type) {
            case I:
                size = 4;
                break;
            case O:
                size = 2;
            default:
                size = 3;
                break;
        }

        switch (type) {
            case I:
                color = Color.CYAN;
                break;
            case O:
                color = Color.YELLOW;
                break;
            case T:
                color = Color.MAGENTA;
                break;
            case L:
                color = Color.ORANGE;
                break;
            case J:
                color = Color.BLUE;
                break;
            case Z:
                color = Color.RED;
                break;
            case S:
                color = Color.GREEN;
                break;
        }

        x = 4;
        y = -2;

        try {
            bounds = blockBuilder(type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void rotate() {
        rotation ++;
        if(rotation == 4) rotation = 0;
    }

    public int[][][] blockBuilder(BlockType type) throws FileNotFoundException {
        int[][][] bounds;
        switch (type) {
            case I:
                bounds = new int[4][4][4];
                break;
            case O:
                bounds = new int[4][2][2];
                break;
            default:
                bounds = new int[4][3][3];
        }

        File file = new File("resources/blocks/" + type + ".txt");
        Scanner scanner = new Scanner(file);

        for (int variant = 0; variant < 4; variant++) {
            for (int i = 0; i < bounds[0].length; i++) {
                if(scanner.hasNext()) {
                    String[] srow = scanner.next().split("");
                    int[] row = new int[bounds[0].length];

                    for (int j = 0; j < row.length; j++) {
                        row[j] = Integer.valueOf(srow[j]);
                        bounds[variant][j][i] = row[j];
                    }
                }
            }
        }

        return bounds;
    }


    public BlockType getType() {
        return type;
    }

    public void setType(BlockType type) {
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getRotation() {
        return rotation;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    public int[][][] getBounds() {
        return bounds;
    }

    public void setBounds(int[][][] bounds) {
        this.bounds = bounds;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean moveable) {
        this.moveable = moveable;
    }

    public int getTypeValue() {
        switch (type) {
            case I:
                return 1;
            case O:
                return 2;
            case T:
                return 3;
            case L:
                return 4;
            case J:
                return 5;
            case Z:
                return 6;
            case S:
                return 7;
        }

        return 0;

    }
}
