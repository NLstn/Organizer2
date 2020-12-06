package com.nlstn;

import java.util.logging.Logger;

import com.nlstn.processor.Processor;

/**
 * Hello world!
 */
public final class App {

    private static LaunchConfig launchConfig;
    private static Logger logger;

    public static void main(String[] args) {
        logger = Logger.getLogger(App.class.getName());
        logger.info("Starting Organizer2");
        try {
            launchConfig = LaunchConfig.parse(args);
        } catch (Exception e) {
            logger.severe(e.getMessage());
            System.exit(-1);
        }
        if (launchConfig.isEmpty()) {
            // UI Mode
            logger.config("Choosing UI mode");
        } else {
            // CLI mode
            logger.config("Choosing CLI mode");
            String folderPath = launchConfig.get("-f");
            String pattern = launchConfig.get("-p");

            Processor.setFolderPath(folderPath);
            Processor.setPattern(pattern);

            try {
                Processor.validateParams();
            } catch (Exception e) {
                logger.severe(e.getMessage());
            }
        }
    }

}
