package com.nlstn;

import static org.junit.jupiter.api.Assertions.assertThrows;

import com.nlstn.processor.InvalidProcessorParams;
import com.nlstn.processor.Processor;

import org.junit.jupiter.api.Test;

public class TestProcessorParamValidation {

    @Test
    public void testMissingPattern() {

        assertThrows(InvalidProcessorParams.class, () -> {
            Processor processor = new Processor();
            processor.setFolderPath("./test");
            processor.organize();
        });

    }

    @Test
    public void testMissingFolder() {

        assertThrows(InvalidProcessorParams.class, () -> {
            Processor processor = new Processor();
            processor.setPattern("test");
            processor.organize();
        });

    }

    @Test
    public void testValid() throws Exception {

        Processor processor = new Processor();
        processor.setPattern("test");
        processor.setFolderPath("./test");
        processor.organize();

    }

}
