package com.nlstn.processor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.logging.Logger;

import com.nlstn.files.ProcessableFile;

public class Processor {

    private static Logger logger = Logger.getLogger(Processor.class.getName());

    private static Path folderPath;
    private static String pattern;

    private static List<ProcessableFile> files;

    public static void validateParams() throws Exception {
        logger.info("Validating parameters");
        if (folderPath == null) {
            throw new InvalidProcessorParams("Folder is not set");
        }

        if (!Files.isDirectory(folderPath)) {
            throw new InvalidProcessorParams(folderPath.toString() + " is not a folder");
        }

        if (pattern == null || pattern.equals("")) {
            throw new InvalidProcessorParams("Pattern is not set");
        }
    }

    public static void listFiles() {
        logger.info("Listing files");
        files = new ArrayList<>();

        try (Stream<Path> stream = Files.walk(folderPath)) {
            stream.forEach((path) -> {
                files.add(ProcessableFile.get(path));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setFolderPath(String folderPath) {
        Processor.folderPath = Paths.get(folderPath).normalize();
    }

    public static List<ProcessableFile> getCurrentFiles() {
        return files;
    }

    public static String getFolderPath() {
        return folderPath.toAbsolutePath().toString();
    }

    public static String getPattern() {
        return pattern;
    }

    public static void setPattern(String pattern) {
        Processor.pattern = pattern;
    }

    public void clear() {
        Processor.files = null;
        Processor.folderPath = null;
        Processor.pattern = null;
    }

}
