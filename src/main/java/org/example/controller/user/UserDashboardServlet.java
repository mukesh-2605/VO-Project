package org.example.controller.user;

import org.example.DB.VendorDAO;
import org.example.model.Vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class UserDashboardServlet extends HttpServlet {

    private VendorDAO vendorDAO;

    @Override
    public void init() {
        vendorDAO = new VendorDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || !"user".equals(session.getAttribute("userRole")) || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("index.jsp");
            return; // Stop execution
        }

        // --- Fetch Data for all three statuses ---
        List<Vendor> approvedVendors = vendorDAO.getVendorsByStatus("Approved");
        request.setAttribute("approvedVendorList", approvedVendors);

        List<Vendor> pendingVendors = vendorDAO.getVendorsByStatus("Pending");
        request.setAttribute("pendingVendorList", pendingVendors);

        List<Vendor> rejectedVendors = vendorDAO.getVendorsByStatus("Rejected");
        request.setAttribute("rejectedVendorList", rejectedVendors);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/User/user_dashboard.jsp").forward(request, response);
    }
}
