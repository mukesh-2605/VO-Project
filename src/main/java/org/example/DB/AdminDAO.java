package org.example.DB;

/* *
 *
 * @author Java Programming with Aldrin
 */


import org.example.DBConfig;
import org.example.model.User;
import org.example.model.Vendor;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminDAO {
    private final String jdbcURL = new DBConfig().getJdbcURL();
    private final String jdbcUsername = new DBConfig().getJdbcUsername();
    private final String jdbcPassword = new DBConfig().getJdbcPassword();

    private static final String ADD_VENDORS_SQL = "INSERT INTO vendor_password_manager (v_email, password) VALUES (?, ?)";
    private static final String INSERT_VENDORS_SQL = "INSERT INTO vendor_details (v_email, status) VALUES (?, ?)";
    private static final String SELECT_ALL_VENDORS_SQL = "SELECT id, v_email, v_name, company_name FROM vendor_details";
    private static final String SELECT_ALL_USERS_SQL = "SELECT pd.emp_id, pd.email, pd.name FROM user_profile_details pd JOIN emp_password_manager pm ON pd.emp_id = pm.emp_id";
    private static final String DELETE_VENDOR_SQL1 = "DELETE FROM vendor_details WHERE id = ?";
    private static final String DELETE_VENDOR_SQL2 = "DELETE FROM vendor_password_manager WHERE id = ?";
    //private static final String SELECT_VENDOR_BY_STATUS = "SELECT "

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


    // ADD_VENDORS_SQL
    // add servlet in admin and get vendor mail and put here
    public void requestNewVendor(String mail) throws SQLException {
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement1 = connection.prepareStatement(ADD_VENDORS_SQL);
                 PreparedStatement preparedStatement2 = connection.prepareStatement(INSERT_VENDORS_SQL)) {

                preparedStatement1.setString(1, mail);
                preparedStatement1.setString(2, mail);
                preparedStatement1.executeUpdate();

                preparedStatement2.setString(1, mail);
                preparedStatement2.setString(2, "requested");
                preparedStatement2.executeUpdate();

                connection.commit();  // Commit only if both succeed
            } catch (SQLException e) {
                connection.rollback(); // Optional: rollback if something fails
                printSQLException(e);
            }
        }

    }

    public List<Vendor> getAllVendors() throws SQLException {
        List<Vendor> vendors = new ArrayList<>();

        try (Connection connection = getConnection()) {

            // Fetch vendors
            try (PreparedStatement stmt1 = connection.prepareStatement(SELECT_ALL_VENDORS_SQL);
                 ResultSet rs1 = stmt1.executeQuery()) {

                while (rs1.next()) {
                    int id = rs1.getInt("id");
                    String email = rs1.getString("v_email");
                    String name = rs1.getString("v_name");
                    String company_name = rs1.getString("company_name");
                    vendors.add(new Vendor(id, name, email, company_name));
                }
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return vendors;
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection connection = getConnection()) {

            // Fetch users
            try (PreparedStatement stmt2 = connection.prepareStatement(SELECT_ALL_USERS_SQL);
                 ResultSet rs2 = stmt2.executeQuery()) {

                while (rs2.next()) {
                    String email = rs2.getString("email");
                    String name = rs2.getString("name");
                    users.add(new User(email, name));
                }

                System.out.println("USERS: " + users);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteVendor(int id) throws SQLException {
        try (Connection connection = getConnection()) {
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatement1 = connection.prepareStatement(DELETE_VENDOR_SQL1);
                 PreparedStatement preparedStatement2 = connection.prepareStatement(DELETE_VENDOR_SQL2)) {

                preparedStatement1.setInt(1, id);
                preparedStatement1.executeUpdate();

                preparedStatement2.setInt(1, id);
                preparedStatement2.executeUpdate();

                connection.commit();  // Commit only if both succeed
                return true;
            } catch (SQLException e) {
                connection.rollback(); // Optional: rollback if something fails
                printSQLException(e);
                throw new RuntimeException("Failed to delete vendor with ID: " + id, e);
            }
        }
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}

