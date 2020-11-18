package com.nlstn.processor;

public class Processor {

    private String folderPath;
    private String pattern;

    public void setFolderPath(String folderPath) {
        this.folderPath = folderPath;
    }

    public String getFolderPath() {
        return folderPath;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void organize() throws Exception {
        validateParams();
    }

    private void validateParams() throws Exception {
        if (folderPath == null || folderPath.equals("")) {
            throw new InvalidProcessorParams("Folder is not set");
        }
        if (pattern == null || pattern.equals("")) {
            throw new InvalidProcessorParams("Pattern is not set");
        }
    }

}
