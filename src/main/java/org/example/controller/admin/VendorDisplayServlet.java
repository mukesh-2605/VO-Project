package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.VendorDAO;
import org.example.model.Vendor;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/vendors")
public class VendorDisplayServlet extends HttpServlet {
    private VendorDAO vendorDAO = new VendorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Vendor> pendingVendorList = vendorDAO.getVendorsByStatus("pending"); // Fetch from DB
            List<Vendor> requestedVendorList = vendorDAO.getVendorsByStatus("requested");
            List<Vendor> approvedVendorList = vendorDAO.getVendorsByStatus("approved");
            List<Vendor> reviewVendorList = vendorDAO.getVendorsByStatus("review");
            List<Vendor> rejectedVendorList = vendorDAO.getVendorsByStatus("rejected");
            request.setAttribute("pendingVendors", pendingVendorList); // Send to JSP
            request.setAttribute("requestedVendors", requestedVendorList);
            request.setAttribute("approvedVendors", approvedVendorList);
            request.setAttribute("reviewVendors", reviewVendorList);
            request.setAttribute("rejectedVendors", rejectedVendorList);
            request.getRequestDispatcher("/admin/vendor-display.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new ServletException("Servlet error", e);
        }
    }
}