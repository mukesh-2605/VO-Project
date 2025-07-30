package org.example.DB;

import org.example.DBConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import org.example.model.Vendor;
import java.util.*;

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

    /**
     * Retrieves a list of vendors from the database based on their status.
     * @param status The status to filter by (e.g., "Approved", "Pending").
     * @return A List of Vendor objects matching the status.
     */

    public List<Vendor> getVendorsByStatus(String status) {
        // Create a list to hold the vendors
        List<Vendor> vendors = new ArrayList<>();
        // The SQL query with a placeholder (?) for the status parameter
        String sql = "SELECT v_name,v_email,company_name FROM vendor_details WHERE status = ?";

        // Use try-with-resources to automatically close the connection, statement, and result set
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Set the value for the placeholder
            preparedStatement.setString(1, status);

            // Execute the query and get the result set
            ResultSet rs = preparedStatement.executeQuery();

            // Loop through each row in the result set
            while (rs.next()) {
                // Retrieve data from the current row

                String vendorName  = rs.getString("name");
                String companyName = rs.getString("company_name");
                String vEmail = rs.getString("v_email");

                // Creating a new Vendor object and add it to the list and add to vendor list
                Vendor vendor = new Vendor(vendorName,vEmail,companyName);
                vendors.add(vendor);
            }
        } catch (SQLException e) {
            // Print the stack trace for debugging purposes.
            // In a real application, you would use a logging framework.
            e.printStackTrace();
        }

        // Return the list of vendors (it will be empty if none are found or an error occurs)
        return vendors;
    }
}
