package org.example.controller.user;

import org.example.model.Vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * File: UserDashboardServlet.java
 * Description: This servlet fetches the list of vendors assigned to the logged-in user
 * from the database and forwards them to the user_dashboard.jsp for display.
 */
@WebServlet("/userDashboard") // This annotation maps the servlet to the URL
public class UserDashboardServlet extends HttpServlet {

    // --- IMPORTANT: Replace with your actual database connection details ---
    private static final String DB_URL = "jdbc:mysql://localhost:3306/VendorOnboarding";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "adminadmin";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Get existing session, don't create a new one

        // --- User Authentication and Authorization Check ---
        // In a real app, you'd have a robust check.
        // If the session is null or the user is not logged in, redirect to the login page.
        if (session == null || session.getAttribute("employmentId") == null) {
            response.sendRedirect("login.jsp");
            return; // Stop further execution
        }

        // Get the logged-in user's ID from the session.
        String loggedInUserId = (String) session.getAttribute("employmentId");
        List<Vendor> vendorList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        // The SQL query to get vendors for a specific user.
        // We only select the columns needed for the dashboard.
        String sql = "SELECT v_email, company_name, status, remarks FROM vendorDetails WHERE userid = ?";

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Create a PreparedStatement to prevent SQL injection
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loggedInUserId); // Set the user ID parameter

            // Execute the query
            rs = pstmt.executeQuery();

            // Process the result set
//            while (rs.next()) {
//                String vEmail = rs.getString("v_email");
//                String companyName = rs.getString("company_name");
//                String status = rs.getString("status");
//                String remarks = rs.getString("remarks");
//
//                // Create a Vendor object and add it to the list
//                vendorList.add(new Vendor(vEmail, companyName, status, remarks));
//            }

        } catch (ClassNotFoundException | SQLException e) {
            // Proper error handling is crucial. Log the error.
            e.printStackTrace(); // For debugging. In production, use a logging framework.
            // You might want to forward to an error page.
            throw new ServletException("Database error while fetching vendors.", e);
        } finally {
            // --- IMPORTANT: Always close database resources in a finally block ---
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Set the list of vendors as a request attribute
        request.setAttribute("vendorList", vendorList);

        // Forward the request and response to the JSP page for rendering
        request.getRequestDispatcher("user_dashboard.jsp").forward(request, response);
    }
}
