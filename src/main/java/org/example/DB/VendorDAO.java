package org.example.DB;

import org.example.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class VendorDAO {
    private final String jdbcURL = new DBConfig().getJdbcURL();
    private final String jdbcUsername = new DBConfig().getJdbcUsername();
    private final String jdbcPassword = new DBConfig().getJdbcPassword();

    protected Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            if (connection == null) {
                throw new SQLException("Connection returned null — check DB credentials or URL.");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }
    public Connection newConnection() throws SQLException {
        Connection connection=getConnection();
        return connection;
    }
}
