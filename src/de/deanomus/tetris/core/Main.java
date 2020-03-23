package de.deanomus.tetris.core;

import de.deanomus.tetris.objects.blocks.Line;
import de.deanomus.tetris.ui.Gui;

public class Main {



    public static void main(String[] args) {
        new Gui();
        Line l = new Line();
        System.out.println(l);
    }

}
