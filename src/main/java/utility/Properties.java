package utility;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

    private static Properties instance = null;
    private java.util.Properties properties;

    // Private constructor to prevent instantiation
    private Properties() {
        properties = new java.util.Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    // Global access point to the singleton instance
    public static Properties getInstance() {
        if (instance == null) {
            synchronized (Properties.class) {
                if (instance == null) {
                    instance = new Properties();
                }
            }
        }
        return instance;
    }

    // Get property by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    // Get property by key with a default value
    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}