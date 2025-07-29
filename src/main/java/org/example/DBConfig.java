package org.example;

import java.io.InputStream;
import java.util.Properties;

public class DBConfig {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;

    public DBConfig() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input != null) {
                prop.load(input);
                jdbcURL = prop.getProperty("jdbc.url");
                jdbcUsername = prop.getProperty("jdbc.username");
                jdbcPassword = prop.getProperty("jdbc.password");
            } else {
                throw new RuntimeException("db.properties not found in classpath");
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB config", e);
        }
    }

    public String getJdbcURL() { return jdbcURL; }
    public String getJdbcUsername() { return jdbcUsername; }
    public String getJdbcPassword() { return jdbcPassword; }
}

