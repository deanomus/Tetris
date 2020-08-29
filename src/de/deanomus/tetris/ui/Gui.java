package de.deanomus.tetris.ui;

import de.deanomus.tetris.io.KeyLis;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gui {

    public static final int
                    width = 320, height= 576;

    public static Font pxlfont;

    JFrame frame;

    public Gui() throws IOException, FontFormatException {
        frame = new JFrame("Tetris");
        frame.setSize(width + 17 + 200, height + 40);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.requestFocus();

        pxlfont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/FFFFORWA.TTF")).deriveFont(12f);

        DrawMenu dm = new DrawMenu();
        setupDraw(dm, 0, 0, width+200, height);

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
