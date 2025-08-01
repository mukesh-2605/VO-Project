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
        String sql = "SELECT id, v_name,v_email,company_name FROM vendor_details WHERE status = ?";

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

                int id = rs.getInt("id");
                String vendorName  = rs.getString("v_name");
                String companyName = rs.getString("company_name");
                String vEmail = rs.getString("v_email");

                // Creating a new Vendor object and add it to the list and add to vendor list
                Vendor vendor = new Vendor(id, vendorName,vEmail,companyName);
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

    public List<Integer> preRegisterVendor(String email, String password) {
        String sql = "INSERT INTO vendor_password_manager (v_email, password) VALUES (?, ?)";
        List<Integer> result = new ArrayList<>();
        String sql1 = "SELECT id from vendor_password_manager where v_email=?";

        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);
            ps.setString(2, password);

            int rowsAffected = ps.executeUpdate();

            // executeUpdate() returns the number of rows affected.
            // If it's greater than 0, the insert was successful.
             if (rowsAffected > 0)
                 result.add(1);
             else
                 result.add(0);
        } catch (SQLException e) {
            // This will catch errors, including violations of the UNIQUE constraint on v_email.
            e.printStackTrace();
            return Arrays.asList(0, 0);

        }
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery(sql1);

            if(rs.next()){
                result.add(rs.getInt("id"));
            }
        } catch (SQLException e) {
            // This will catch errors, including violations of the UNIQUE constraint on v_email.
            e.printStackTrace();
            return Arrays.asList(0, 0);
        }
        return result;
    }

//    public Vendor getVendorDetails(int id) throws SQLException {
//        String sql = "SELECT * FROM vendor_details WHERE id = ?";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            // Set the value for the placeholder
//            preparedStatement.setInt(1, id);
//
//            // Execute the query and get the result set
//            ResultSet rs = preparedStatement.executeQuery();
//
//            // Loop through each row in the result set
//            Vendor vendor = new Vendor(
//                    rs.getInt("id"),
//                    rs.getString("mail"),
//                    rs.getString("name"),
//                    rs.getInt("userid"),
//                    rs.getString("company_name"),
//                    rs.getString("category"),
//                    rs.getString("phone_num"),
//                    rs.getString("website"),
//                    rs.getString("payment_terms"),
//                    rs.getString("b_country"),
//                    rs.getString("b_address"),
//                    rs.getString("b_city"),
//                    rs.getString("b_state"),
//                    rs.getString("b_zipcode"),
//                    rs.getString("s_country"),
//                    rs.getString("s_address"),
//                    rs.getString("s_city"),
//                    rs.getString("s_state"),
//                    rs.getString("s_zipcode"),
//                    rs.getString("GSTIN_or_VAT_or_TIN_type"),
//                    rs.getString("GSTIN_or_VAT_or_TIN_number"),
//                    rs.getString("PAN_number"),
//                    rs.getString("business_licence_number"),
//                    rs.getString("beneficiary_name"),
//                    rs.getString("bank_name"),
//                    rs.getString("acc_num"),
//                    rs.getString("acc_type"),
//                    rs.getString("routing_number"),
//                    rs.getString("contact_person_name"),
//                    rs.getString("cp_role"),
//                    rs.getString("cp_phoneNum"),
//                    rs.getString("cp_alter_phoneNum"),
//                    rs.getString("cp_email"),
//                    rs.getString("cp_communication_channel"),
//                    rs.getString("status"),
//                    rs.getString("remarks")
//            );
//            return vendor;
//        } catch (SQLException e) {
//            // Print the stack trace for debugging purposes.
//            // In a real application, you would use a logging framework.
//            e.printStackTrace();
//            throw new RuntimeException("Failed to fetch vendor with ID: " + id, e);
//        }
//    }

//    public Vendor getVendorDetails(int id) throws SQLException {
//        String sql = "SELECT * FROM vendor_details WHERE id = ?";
//
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//
//            preparedStatement.setInt(1, id);
//
//            try (ResultSet rs = preparedStatement.executeQuery()) {
//                if (rs.next()) {
//                    return new Vendor(
//                            rs.getInt("id"),
//                            rs.getString("v_email"),
//                            rs.getString("v_name"),
//                            rs.getInt("userid"),
//                            rs.getString("company_name"),
//                            rs.getString("category"),
//                            rs.getString("phone_num"),
//                            rs.getString("website"),
//                            rs.getString("payment_terms"),
//                            rs.getString("b_country"),
//                            rs.getString("b_address"),
//                            rs.getString("b_city"),
//                            rs.getString("b_state"),
//                            rs.getString("b_zipcode"),
//                            rs.getString("s_country"),
//                            rs.getString("s_address"),
//                            rs.getString("s_city"),
//                            rs.getString("s_state"),
//                            rs.getString("s_zipcode"),
//                            rs.getString("GSTIN_or_VAT_or_TIN_type"),
//                            rs.getString("GSTIN_or_VAT_or_TIN_number"),
//                            rs.getString("PAN_number"),
//                            rs.getString("business_licence_number"),
//                            rs.getString("beneficiary_name"),
//                            rs.getString("bank_name"),
//                            rs.getString("acc_num"),
//                            rs.getString("acc_type"),
//                            rs.getString("routing_number"),
//                            rs.getString("cp_name"),
//                            rs.getString("cp_role"),
//                            rs.getString("cp_phone_num"),
//                            rs.getString("cp_alter_phone_num"),
//                            rs.getString("cp_email"),
//                            rs.getString("cp_communication_channel"),
//                            rs.getString("status"),
//                            rs.getString("remarks")
//                    );
//                } else {
//                    return null; // No vendor found with this ID
//                }
//            }

//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to fetch vendor with ID: " + id, e);
//        }
//    }

}
