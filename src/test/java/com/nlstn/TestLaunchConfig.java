package com.nlstn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestLaunchConfig {

    @Test
    public void testDoubleKeyFirst() {
        String[] args = { "-p", "-q" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig.parse(args);
        });
    }

    @Test
    public void testNoKeyFirst() {
        String[] args = { "-p", "q", "p", "q" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig.parse(args);
        });
    }

    @Test
    public void testDoubleKeySecond() {
        String[] args = { "-p", "q", "-p", "-q" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig.parse(args);
        });
    }

    @Test
    public void testNoKeySecond() {
        String[] args = { "p", "q" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig.parse(args);
        });
    }

    public void testNotEmpty() {
        String[] args = { "-p", "q" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig config = LaunchConfig.parse(args);
            assertEquals(config.isEmpty(), false);
        });
    }

    public void testEmpty() {
        String[] args = {};

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig config = LaunchConfig.parse(args);
            assertEquals(config.isEmpty(), true);
        });
    }

}
