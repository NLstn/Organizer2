package com.nlstn;

/**
 * Hello world!
 */
public final class App {

    private static LaunchConfig launchConfig;

    public static void main(String[] args) throws Exception {
        launchConfig = LaunchConfig.parse(args);
        if (launchConfig.isEmpty()) {
            // UI Mode
        } else {
            // CLI mode
        }
    }

}
