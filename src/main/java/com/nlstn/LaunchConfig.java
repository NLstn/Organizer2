package com.nlstn;

import java.util.HashMap;
import java.util.Map;

public class LaunchConfig {

    private LaunchConfig() {
    }

    public static LaunchConfig parse(String[] args) throws LaunchConfigException {
        LaunchConfig config = new LaunchConfig();

        String key = "";
        for (String string : args) {
            if (key == "") {
                // expect key
                if (string.startsWith("-"))
                    key = string;
                else
                    throw new LaunchConfigException("Unexpected token " + string);
            } else {
                // expect value
                if (!string.startsWith("-"))
                    config.config.put(key, string);
                else
                    throw new LaunchConfigException("Unexpected token " + string);
                key = "";
            }
        }
        return config;
    }

    private final Map<String, String> config = new HashMap<>();

    public boolean isEmpty() {
        return config.size() == 0;
    }

    public String get(String key) {
        return config.get(key);
    }
}
