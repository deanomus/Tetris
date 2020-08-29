package de.deanomus.tetris.core;

import de.deanomus.tetris.objects.Block;
import de.deanomus.tetris.objects.Game;
import de.deanomus.tetris.ui.Gui;

import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Game.currentBlock = new Block();
        Game.blocks.add(Game.currentBlock);
        Game.nextBlock = new Block();

        try {
            new Gui();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FontFormatException e) {
            e.printStackTrace();
        }

        startLoop();
    }


    public static void startLoop() {
        Loop loop = new Loop();
        loop.start();
    }

}
