package com.nlstn;

import com.nlstn.ui.Window;

/**
 * Hello world!
 */
public final class App {

    private Window window;

    private App() {
        window = new Window();
    }

    public static void main(String[] args) {
        new App();
    }

}
