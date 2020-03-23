package de.deanomus.tetris.objects.blocks;

import de.deanomus.tetris.objects.Block;

import java.awt.*;

public class Line extends Block {

    int[][] ib = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {0, 0, 0, 0},
            {0, 0, 0, 0}
    };
    Color color = Color.GREEN;


    public Line() {
        super();
        setup(ib, color);
    }

}
