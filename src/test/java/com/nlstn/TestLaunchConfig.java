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
    public void testNoKeySecond() {
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
    public void testNoKeyFirst() {
        String[] args = { "p", "q" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig.parse(args);
        });
    }

    @Test
    public void testNotEmpty() throws Exception {

        String[] args = { "-p", "q" };

        LaunchConfig config = LaunchConfig.parse(args);
        assertEquals(config.isEmpty(), false);
    }

    @Test
    public void testEmpty() throws Exception {

        String[] args = {};
        LaunchConfig config = LaunchConfig.parse(args);
        assertEquals(config.isEmpty(), true);

    }

    public void testOnlyKey() throws Exception {

        String[] args = { "-p" };

        assertThrows(LaunchConfigException.class, () -> {
            LaunchConfig.parse(args);
        });

    }

}
