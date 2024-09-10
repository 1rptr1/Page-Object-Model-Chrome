package utility;

import java.io.FileInputStream;
import java.io.IOException;

public class Properties {

    private static Properties instance = null;
    private java.util.Properties prop;

    // Private constructor to prevent instantiation
    private Properties() {
        prop = new java.util.Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            prop.load(fis);
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to load properties file. Path to file location is wrong");
        }
    }

    // Global access point to the singleton instance
    public static Properties getInstance() {
        if (instance == null)
            instance = new Properties();
        return instance;
    }

    // Get property by key
    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    // Get property by key with a default value
    public String getProperty(String key, String defaultValue) {
        return prop.getProperty(key, defaultValue);
    }
}