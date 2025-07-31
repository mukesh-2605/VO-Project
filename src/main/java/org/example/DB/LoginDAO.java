package org.example.DB;

import org.example.DBConfig;
import org.example.model.Admin;
import org.example.model.User;
import org.example.model.Vendor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Data Access Object for handling authentication.
 * It validates user credentials against the 'passwordManager' table for specific roles.
 */
public class LoginDAO {
    private final String jdbcURL = new DBConfig().getJdbcURL();
    private final String jdbcUsername = new DBConfig().getJdbcUsername();
    private final String jdbcPassword = new DBConfig().getJdbcPassword();

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (ClassNotFoundException e) {
            throw new SQLException("MySQL JDBC Driver not found.", e);
        }
    }

    /**
     * Validates credentials for a 'user'.
     * @return A User object if valid, otherwise null.
     */
    public User validateUser(String email, String password) {
        // CORRECTED SQL: Removed the non-existent 'name' column.
        String sql = "SELECT email  FROM passwordManager WHERE email = ? AND password = ? AND role = 'user'";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                User user = new User();
                user.setEmail(rs.getString("email"));

                return user; // This will now return a valid User object.
            }
        } catch (SQLException e) {
            // This block will no longer be triggered by the "column not found" error.
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Validates credentials for an 'admin'.
     * @return An Admin object if valid, otherwise null.
     */
    public Admin validateAdmin(String email, String password) {
        String sql = "SELECT email, role FROM passwordManager WHERE email = ? AND password = ? AND role = 'admin'";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setEmail(rs.getString("email"));
                return admin;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Validates credentials for a 'vendor'.
     * @return A Vendor object if valid, otherwise null.
     */
    public Vendor validateVendor(String email, String password) {
        String sql = "SELECT email, role FROM passwordManager WHERE email = ? AND password = ? AND role = 'vendor'";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vendor vendor = new Vendor();
                vendor.setEmail(rs.getString("email"));
                return vendor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
