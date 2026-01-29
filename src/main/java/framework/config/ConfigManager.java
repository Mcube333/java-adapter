package framework.config;

import java.io.InputStream;
import java.util.Properties;

public final class ConfigManager {

    private static final Properties props = new Properties();

    static {
        try {
            String env = System.getProperty("env");

            if (env == null || env.startsWith("${")) {
                env = "qa";
            }

            String fileName = "config/" + env + ".properties";

            InputStream input = ConfigManager.class
                    .getClassLoader()
                    .getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException("Config file not found: " + fileName);
            }

            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load environment configuration", e);
        }
    }

    private ConfigManager() {}

    public static String get(String key) {
        return props.getProperty(key);
    }
}
