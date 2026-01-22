package core.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

    private static Properties props = new Properties();

    static {
        try {
            InputStream input = ConfigManager.class
                .getClassLoader()
                .getResourceAsStream("config/env.properties");
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load env.properties");
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
