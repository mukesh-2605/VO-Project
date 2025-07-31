package org.example.controller;

import org.example.DB.LoginDAO;
import org.example.model.Admin;
import org.example.model.User;
import org.example.model.Vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 * Handles user authentication by routing to role-specific validation.
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private LoginDAO loginDAO;

    @Override
    public void init() {
        loginDAO = new LoginDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        boolean loginSuccess = false;

        // Use a switch to handle role-specific logic
        switch (role) {
            case "user":
                User user = loginDAO.validateUser(email, password);
                if (user != null) {
                    HttpSession session = request.getSession();

                    // --- STANDARDIZED SESSION KEYS ---
                    session.setAttribute("loggedInUser", user); // Store the entire user object
                    session.setAttribute("userRole", "user");   // Store the role for easy checks
                    session.setAttribute("userEmail",email);
                    response.sendRedirect("dashboard");
                    loginSuccess = true;
                }
                break;

//            case "admin":
//                Admin admin = loginDAO.validateAdmin(email, password);
//                if (admin != null) {
//                    HttpSession session = request.getSession();
//                    session.setAttribute("admin", admin); // Store the entire admin object
//                    session.setAttribute("userRole", "admin");
//                    response.sendRedirect("admin_dashboard.jsp");
//                    loginSuccess = true;
//                }
//                break;
//
//            case "vendor":
//                Vendor vendor = loginDAO.validateVendor(email, password);
//                if (vendor != null) {
//                    HttpSession session = request.getSession();
//                    session.setAttribute("vendor", vendor); // Store the entire vendor object
//                    session.setAttribute("userRole", "vendor");
//                    response.sendRedirect("vendor_dashboard.jsp");
//                    loginSuccess = true;
//                }
//                break;
        }

        // If login failed for any role, forward back to the login page with an error
        if (!loginSuccess) {
            request.setAttribute("errorMessage", "Invalid credentials for the selected role.");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }
}

//package org.example.controller;
//
//import org.example.DB.LoginDAO;
//import org.example.DB.UserDAO; // IMPORTANT: We need UserDAO here now
//import org.example.model.User;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.*;
//        import java.io.IOException;
//
//@WebServlet("/login")
//public class LoginServlet extends HttpServlet {
//
//    private LoginDAO loginDAO;
//    private UserDAO userDAO; // We now need an instance of UserDAO
//
//    @Override
//    public void init() {
//        loginDAO = new LoginDAO();
//        userDAO = new UserDAO(); // Initialize the UserDAO
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");
//        String role = request.getParameter("role");
//        boolean loginSuccess = false;
//
//        if ("user".equals(role)) {
//            // Step 1: Validate the password from the passwordManager table
//            User validatedUser = loginDAO.validateUser(email, password);
//
//            if (validatedUser != null) {
//                // Step 2: Password is correct, now fetch the full profile from profileDetails table
//                User profileUser = userDAO.getUserByEmail(email);
//
//                HttpSession session = request.getSession();
//
//                // Store the full profile object in the session
//                session.setAttribute("loggedInUser", profileUser);
//                session.setAttribute("userRole", "user");
//
//                response.sendRedirect("dashboard");
//                loginSuccess = true;
//            }
//        }
//        // ... your other cases for admin/vendor
//
//        if (!loginSuccess) {
//            request.setAttribute("errorMessage", "Invalid credentials for the selected role.");
//            request.getRequestDispatcher("/index.jsp").forward(request, response);
//        }
//    }
//}
