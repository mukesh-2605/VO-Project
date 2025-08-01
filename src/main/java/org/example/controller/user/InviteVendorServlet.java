package org.example.controller.user; // Or your preferred controller package

import org.example.DB.VendorDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.model.Vendor;
import java.util.*;
import java.io.IOException;

/**
 * Handles the initial invitation of a new vendor.
 * It creates a login for the vendor and then redirects to the full profile creation page.
 */
@WebServlet("/inviteVendor")
public class InviteVendorServlet extends HttpServlet {

    private VendorDAO vendorDAO;

    @Override
    public void init() {
        vendorDAO = new VendorDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String vendorEmail = request.getParameter("vendorEmail");
        String vendorPassword = request.getParameter("vendorPassword");

//         Call the DAO method to pre-register the vendor
        List<Integer> isSuccess = vendorDAO.preRegisterVendor(vendorEmail, vendorPassword);

        if (isSuccess.get(0)==1) {
            // Store the new vendor's email in the session so the next page knows who to edit.
            HttpSession session = request.getSession(false);
            session.setAttribute("newlyInvitedVendorEmail", vendorEmail);
            session.setAttribute("vid",isSuccess.get(1));

            session.setAttribute("vid",isSuccess.get(1));

            response.sendRedirect("/vendor/business-info");

        } else {
            // --- FAILURE ---
            // This likely means the email already exists.
            // Forward back to the invite page with an error message.
            request.setAttribute("errorMessage", "This vendor email already exists. Please use a different one.");
            request.getRequestDispatcher("/vendor/user_dashboard.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("/login.jsp");
            return;
        }
//        Vendor vendor= (Vendor) session.getAttribute("vendor");
        request.getRequestDispatcher("/User/inviteVendor.jsp").forward(request, response);
    }
}
