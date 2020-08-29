package de.deanomus.tetris.core;

import de.deanomus.tetris.objects.Block;
import de.deanomus.tetris.objects.Game;
import de.deanomus.tetris.objects.GameState;

public class Loop extends Thread {

    private boolean running = true;


    @Override
    public void run() {
        while (running) {
            if (Game.gamestate == GameState.ingame) {
                if(!Collision.collideWithWall(Game.currentBlock, 0) && !Collision.collideWithBlock(Game.currentBlock, 0)) {
                    Game.currentBlock.setY(Game.currentBlock.getY() + 1);
                    Collision.collideWithWall(Game.currentBlock, 0);
                }


                if (Game.spawnNewBlock) {
                    Collision.checkFullRow(1);
                    Game.blocks.add(Game.nextBlock);
                    Game.currentBlock = Game.nextBlock;
                    Game.nextBlock = new Block();
                    Game.spawnNewBlock = false;
                }
            }


            if(!(Game.speedup)) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
