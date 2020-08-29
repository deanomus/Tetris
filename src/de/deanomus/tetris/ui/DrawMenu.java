package de.deanomus.tetris.ui;

import de.deanomus.tetris.objects.Game;
import de.deanomus.tetris.objects.GameState;

import javax.swing.*;
import java.awt.*;

public class DrawMenu extends JLabel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        if(Game.gamestate == GameState.start) {
            g.setColor(new Color(24, 70, 145));
            g.fillRect(0, Gui.height / 2 - 50, Gui.width + 200, 100);
            g.setColor(Color.WHITE);
            g.setFont(Gui.pxlfont.deriveFont(14f));
            g.drawString("ENTER zum Starten", Gui.width / 2, Gui.height / 2 + 10);
        } else if(Game.gamestate == GameState.pause) {
            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, Gui.height / 2 - 50, Gui.width + 200, 100);
            g.setColor(Color.WHITE);
            g.setFont(Gui.pxlfont.deriveFont(14f));
            g.drawString("ESC zum weiterspielen", Gui.width/2-10, Gui.height / 2 + 10);
        } else if(Game.gamestate == GameState.end) {
            g.setColor(new Color(175, 28, 28));
            g.fillRect(0, Gui.height / 2 - 50, Gui.width + 200, 100);
            g.setColor(Color.WHITE);
            g.setFont(Gui.pxlfont.deriveFont(14f));
            g.drawString("VERLOREN! Enter zum starten", 75, Gui.height / 2 + 10);
        }

        repaint();
    }







}
