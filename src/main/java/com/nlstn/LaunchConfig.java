package com.nlstn;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class LaunchConfig {

    private static Logger logger;

    static {
        logger = Logger.getLogger(LaunchConfig.class.getName());
    }

    private LaunchConfig() {
    }

    public static LaunchConfig parse(String[] args) throws LaunchConfigException {
        logger.config("Parsing LaunchConfig");
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
        if (!key.equals("")) {
            throw new LaunchConfigException("Key " + key + " without value");
        }
        return config;
    }

    private final Map<String, String> config = new HashMap<>();

    public boolean isEmpty() {
        return config.size() == 0;
    }

    public String get(String key) {
        logger.config("Reading key " + key);
        return config.get(key);
    }
}
