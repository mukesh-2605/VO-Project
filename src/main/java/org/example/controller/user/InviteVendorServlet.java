package org.example.controller.user;

import org.example.DB.VendorDAO;
import org.example.model.User; // You need to import the User model

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

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

        // --- FIX 1: Get the current user's ID correctly from the session ---
        HttpSession session = request.getSession(false); // Get session without creating a new one

        // Security check: Make sure a user is actually logged in.
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp"); // Redirect to login
            return;
        }

        // Get the User object from the session
        User currentUser = (User) session.getAttribute("loggedInUser");
        // Get the employment ID from the User object
        int currentUserId = Integer.parseInt(currentUser.getEmploymentId());

        // Call the DAO method to pre-register the vendor
        Integer generatedID = vendorDAO.preRegisterVendor(vendorEmail, vendorPassword); // Assuming it returns Integer

        if (generatedID != null && generatedID > 0) {
            // --- SUCCESS ---
            System.out.println("Pre-registration successful for vendor ID: " + generatedID);
            System.out.println("Associating with user ID: " + currentUserId);

            // --- FIX 2: Use the user ID we correctly retrieved ---
            vendorDAO.insertIntoVendor(vendorEmail, currentUserId);

            // Store the new vendor's ID in the session for the next step
            session.setAttribute("vid", generatedID);

            response.sendRedirect(request.getContextPath() + "/vendor/business-info");

        } else {
            // --- FAILURE ---
            System.out.println("Pre-registration failed. Vendor email might already exist.");

            request.setAttribute("errorMessage", "This vendor email already exists. Please use a different one.");
            // --- FIX 3: Forward back to the correct JSP to show the error ---
            request.getRequestDispatcher("/User/inviteVendor.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loggedInUser") == null) {
            response.sendRedirect(request.getContextPath() + "/index.jsp"); // Use context path for safety
            return;
        }
        request.getRequestDispatcher("/User/inviteVendor.jsp").forward(request, response);
    }
}
