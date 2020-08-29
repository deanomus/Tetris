package de.deanomus.tetris.io;

import de.deanomus.tetris.core.Collision;
import de.deanomus.tetris.objects.Game;
import de.deanomus.tetris.objects.GameState;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyLis implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (Game.gamestate == GameState.start) {
            if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                Game.gamestate = GameState.ingame;
            }
        }

        if (Game.gamestate == GameState.ingame) {
            if(e.getKeyCode() == KeyEvent.VK_SPACE) {
                if(!Collision.collideInRotation(Game.currentBlock)) {
                    Game.currentBlock.rotate();
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                Game.speedup = true;
            }

            if(e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (!Collision.collideWithWall(Game.currentBlock, -1)) {
                    Game.currentBlock.setX(Game.currentBlock.getX() - 1);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (!Collision.collideWithWall(Game.currentBlock, 1)) {
                    Game.currentBlock.setX(Game.currentBlock.getX() + 1);
                }
            }
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                Game.gamestate = GameState.pause;
            }
        } else if (Game.gamestate == GameState.pause && e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            Game.gamestate = GameState.ingame;
        } else if (Game.gamestate == GameState.end && e.getKeyCode() == KeyEvent.VK_ENTER) {
            Game.gamestate = GameState.ingame;
            Game.clear();
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(Game.gamestate == GameState.ingame && e.getKeyCode() == KeyEvent.VK_DOWN) {
            Game.speedup = false;
        }

    }
}
