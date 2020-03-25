package de.deanomus.tetris.objects.blocks;

import de.deanomus.tetris.objects.Block;

import java.awt.*;

public class Line extends Block {

    public Line() {
        super();
        color = Color.GREEN;
        ib = new int[][]{
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
    }

}
