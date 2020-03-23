package de.deanomus.tetris.ui;

import de.deanomus.tetris.io.KeyLis;

import javax.swing.*;

public class Gui {

    public static final int
                    width = 320, height= 576;

    JFrame frame;

    public Gui() {
        frame = new JFrame("Tetris");
        frame.setSize(width + 17 + 200, height + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.requestFocus();

        frame.addKeyListener(new KeyLis());

        DrawGame dg = new DrawGame();
        setupDraw(dg, 0, 0, width + 1, height + 1);

        DrawInterface di = new DrawInterface();
        setupDraw(di, width + 1, 1, width, height);

        frame.setVisible(true);
    }

    private void setupDraw(JLabel draw, int x, int y, int width, int height) {
        draw.setBounds(x, y, width, height);
        draw.setVisible(true);
        frame.add(draw);
    }

}
