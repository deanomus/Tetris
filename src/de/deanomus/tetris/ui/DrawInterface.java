package de.deanomus.tetris.ui;

import de.deanomus.tetris.objects.Game;
import de.deanomus.tetris.util.Conversion;

import javax.swing.*;
import java.awt.*;

public class DrawInterface extends JLabel {


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        g.setColor(Game.nextBlock.getColor());
        for (int i = 0; i < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()].length; i++) {
            for (int j = 0; j < Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i].length;j++) {
                if(Game.nextBlock.getBounds()[Game.nextBlock.getRotation()][i][j] == 1) {

                    g.fillRect(Conversion.celltoCoord(1 + i),
                                Conversion.celltoCoord(j),
                            32, 32);

                }
            }
        }

        g.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                g.drawRect(i * 32 + 32, j * 32, 32, 32);
            }
        }

        g.setColor(Color.BLACK);
        g.drawRect(32, 0, 128, 128);


        g.setFont(Gui.pxlfont);
        g.drawString("Score: " + Game.score, 32, 200);
        g.drawString("Highscore: " + Game.highscore, 32, 250);

        repaint();
    }
}
