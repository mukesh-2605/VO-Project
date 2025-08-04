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
    public Connection newConnection() throws SQLException {
        Connection connection=getConnection();
        return connection;
    }

    /**
     * Validates credentials for a 'user'.
     * @return A User object if valid, otherwise null.
     */





    public User validateUser(String email, String password) {
        User user = null;

        String sql = "SELECT upd.emp_id, upd.email, upd.name, upd.phone_num, upd.role, upd.report_to " +
                "FROM emp_password_manager epm " +
                "JOIN user_profile_details upd ON epm.emp_id = upd.emp_id " +
                "WHERE epm.email = ? AND epm.password = ? AND epm.role = 'user'";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();

                user.setEmploymentId(rs.getInt("emp_id"));
                user.setEmail(rs.getString("email"));
                user.setName(rs.getString("name"));
                user.setPhoneNumber(rs.getString("phone_num"));
                user.setReportTo(rs.getInt("report_to"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Return the complete User object, or null if login failed.
        return user;
    }

    /**
     * Validates credentials for an 'admin'.
     * @return An Admin object if valid, otherwise null.
     */
    public Admin validateAdmin(String email, String password) {
        String sql = "SELECT apd.emp_id, apd.email, apd.name, apd.phone_num, apd.role FROM emp_password_manager epm JOIN admin_profile_details apd ON epm.emp_id = apd.emp_id WHERE epm.email = ? AND epm.password = ? AND epm.role = ?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ps.setString(3, "admin");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin();
                admin.setEmail(rs.getString("email"));
                admin.setEmployment_id(rs.getInt("emp_id"));
                admin.setName(rs.getString("name"));
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
        String sql = "SELECT id,v_email, password FROM vendor_password_manager WHERE v_email = ? AND password = ?";
        String sql2="select status from vendor_details where id=?";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Vendor vendor = new Vendor();
                vendor.setId(rs.getInt("id"));
                vendor.setEmail(email);
                vendor.setPassword(password);

                PreparedStatement ps2= conn.prepareStatement(sql2);
                ps2.setInt(1,vendor.getId());
                ResultSet rs2=ps2.executeQuery();
                rs2.next();
                vendor.setStatus(rs2.getString("status"));
                return vendor;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
