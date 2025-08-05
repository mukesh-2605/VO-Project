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
@WebServlet("/userProfile")
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

        HttpSession session = request.getSession(false);

        if (session == null || !session.getAttribute("userRole").equals("user")) {
            response.sendRedirect(request.getContextPath()+"/login.jsp");
            return;
        }
        // Get the user's email securely from the session.
        String email = (String) session.getAttribute("userEmail");

        // Fetch the full user object from the database.
        User user = userDAO.getUserDetails((int)session.getAttribute("empID"));

        // Place the user object in the request scope to be accessed by the JSP.
        request.setAttribute("user", user);
        System.out.println(user.getReportTo());

        // Forward the request to the JSP page for rendering.
        request.getRequestDispatcher("/User/user_profile.jsp").forward(request, response);
    }
}