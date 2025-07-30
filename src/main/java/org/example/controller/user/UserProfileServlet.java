package org.example.controller.user;

import org.example.DB.UserDAO;
import org.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

/**
 * Handles requests for the user profile page.
 * It securely retrieves the logged-in user's information from the session
 * and forwards it to the JSP for display.
 */
@WebServlet("/user/userProfile")
public class UserProfileServlet extends HttpServlet {

    private UserDAO userDAO;

    @Override
    public void init() {
        // This is a good practice: initialize the DAO once when the servlet is created.
        userDAO = new UserDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the current session. Do not create a new one if it doesn't exist.
        HttpSession session = request.getSession(false);

        // --- SECURITY CHECK ---
        // If there's no session or no user email in the session, the user is not logged in.
        // Redirect them to the login page.

        if (session == null || session.getAttribute("userEmail") == null) {
            response.sendRedirect("/login.jsp"); // Or your context path + "/login.jsp"
            return; // Stop further execution.
        }

        // Get the user's email securely from the session.
        String email = (String) session.getAttribute("userEmail");

        // Fetch the full user object from the database.
        User user = userDAO.getUserByEmail(email);

        // Place the user object in the request scope to be accessed by the JSP.
        request.setAttribute("user", user);

        // Forward the request to the JSP page for rendering.
        // The name is updated to match our previous JSP file.
        request.getRequestDispatcher("/User/user_profile.jsp").forward(request, response);
    }
}