package e2e.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigReader.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.trim().isEmpty()) {
            return systemValue;
        }

        String normalizedEnvKey = key
                .replace('.', '_')
                .replace('-', '_')
                .toUpperCase();

        String normalizedEnvValue = System.getenv("E2E_" + normalizedEnvKey);
        if (normalizedEnvValue != null && !normalizedEnvValue.trim().isEmpty()) {
            return normalizedEnvValue;
        }

        return properties.getProperty(key);
    }

    public static String getRequired(String key) {
        String value = get(key);

        if (value == null || value.trim().isEmpty()) {
            throw new IllegalStateException("Missing required configuration key: " + key);
        }

        return value;
    }
}
