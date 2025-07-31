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
            response.sendRedirect("index.jsp");
            return;
        }

        // --- Fetch Data for all three statuses ---

        // 1. Get Approved Vendors
        List<Vendor> approvedVendors = vendorDAO.getVendorsByStatus("Approved");
        request.setAttribute("approvedVendorList", approvedVendors);

        // 2. Get Pending Vendors
        List<Vendor> pendingVendors = vendorDAO.getVendorsByStatus("Pending");
        request.setAttribute("pendingVendorList", pendingVendors);

        // 3. Get Rejected Vendors
        List<Vendor> rejectedVendors = vendorDAO.getVendorsByStatus("Rejected");
        request.setAttribute("rejectedVendorList", rejectedVendors);

        // Forward the request (with all the data) to the JSP page
        request.getRequestDispatcher("/user_dashboard.jsp").forward(request, response);

    }
}