package framework.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static final Properties props = new Properties();

    static {
        try {
            String env = System.getProperty("env", "").trim();
            String fileName = env.isEmpty()
                    ? "config/env.properties"
                    : "config/env-" + env + ".properties";

            InputStream input = ConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException("Configuration file not found: " + fileName);
            }

            props.load(input);
            System.out.println("Loaded configuration: " + fileName);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load environment configuration", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
