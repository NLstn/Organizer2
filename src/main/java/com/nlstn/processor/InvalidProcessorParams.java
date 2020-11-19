package com.nlstn.processor;

public class InvalidProcessorParams extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidProcessorParams(String message) {
        super(message);
    }
}
