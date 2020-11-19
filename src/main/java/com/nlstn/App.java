package com.nlstn;

import com.nlstn.processor.Processor;

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
            String folderPath = launchConfig.get("-f");
            String pattern = launchConfig.get("-p");

            Processor.setFolderPath(folderPath);
            Processor.setPattern(pattern);

            Processor.validateParams();
        }
    }

}
