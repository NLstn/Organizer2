package com.nlstn.files;

import java.nio.file.Path;

public class ProcessableFile {

    private Path path;

    private ProcessableFile(Path path) {
        this.path = path;
    }

    public static ProcessableFile get(Path path) {
        return new ProcessableFile(path);
    }

    public void process() {
        System.out.println(path);
    }

}
