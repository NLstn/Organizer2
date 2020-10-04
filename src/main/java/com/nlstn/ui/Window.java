package com.nlstn.ui;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window {

    private JFrame frame;
    private final int INITIAL_WIDTH = 1200;
    private final int INITIAL_HEIGHT = INITIAL_WIDTH / 16 * 9;

    public Window() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            // not gonna happen
            e.printStackTrace();
        }
        frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(INITIAL_WIDTH, INITIAL_HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Organizer");

        frame.setVisible(true);
    }

}
