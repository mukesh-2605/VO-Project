package org.example.controller.user;

import org.example.DB.VendorDAO;
import org.example.model.Vendor; // Make sure you have a Vendor model class

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

/**
 * Prepares all necessary data for the user dashboard.
 * It ensures the user is authenticated, fetches the list of approved vendors,
 * and then forwards the request to the JSP for display.
 */
@WebServlet("/dashboard")
public class UserDashboardServlet extends HttpServlet {

    private VendorDAO vendorDAO;

    @Override
    public void init() {
        vendorDAO = new VendorDAO(); // Initialize your Vendor Data Access Object
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        // Security check: If no session, redirect to login
        if (session == null || session.getAttribute("userEmail") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // --- Fetch Data ---
        // Call a method in your DAO to get vendors with "Approved" status
        List<Vendor> approvedVendors = vendorDAO.getVendorsByStatus("Approved");

        // Set the fetched list as a request attribute so the JSP can access it
        request.setAttribute("approvedVendorList", approvedVendors);

        // Forward the request (with the data) to the JSP page
        request.getRequestDispatcher("/user_dashboard.jsp").forward(request, response);
    }
}