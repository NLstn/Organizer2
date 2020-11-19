package com.nlstn;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nlstn.processor.InvalidProcessorParams;
import com.nlstn.processor.Processor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class TestProcessorParamValidation {

    @AfterEach
    public void cleanProcessor() {

    }

    @Test
    public void testMissingPattern() {

        assertThrows(InvalidProcessorParams.class, () -> {
            Processor.setFolderPath("./test");
            Processor.validateParams();
        });

    }

    @Test
    public void testMissingFolder() {

        assertThrows(InvalidProcessorParams.class, () -> {
            Processor.setPattern("test");
            Processor.validateParams();
        });

    }

    @Test
    public void testValid() throws Exception {

        Processor.setPattern("test");
        Processor.setFolderPath("/home");
        Processor.validateParams();

    }

}
