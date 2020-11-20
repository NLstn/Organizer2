package com.nlstn.ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

public class MainFrame {

    private JFrame frame;

    public MainFrame() {
        frame = new JFrame("Organizer2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        centerOnScreen();
        frame.setVisible(true);
    }

    private void centerOnScreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] screens = ge.getScreenDevices();
        if (screens.length == 1) {
            frame.setLocationRelativeTo(null);
        } else {
            int width = screens[0].getDefaultConfiguration().getBounds().width;
            int height = screens[0].getDefaultConfiguration().getBounds().height;
            frame.setLocation(
                    ((width / 2) - (frame.getSize().width / 2)) + screens[0].getDefaultConfiguration().getBounds().x,
                    ((height / 2) - (frame.getSize().height / 2)) + screens[0].getDefaultConfiguration().getBounds().y);
        }
    }

}
