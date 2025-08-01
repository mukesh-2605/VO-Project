package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.DB.UserDAO;
import org.example.DB.VendorDAO;
import org.example.model.User;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/viewUserDetails")
public class ViewUserDetails extends HttpServlet {
    UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id;
            id = Integer.parseInt(request.getParameter("id"));

            //request.setAttribute("vendor", vendorDAO.getVendorDetails(id));
            User user = userDAO.getUserDetails(id);
            request.setAttribute("user", user); // Correct
            System.out.println("this id " + id);
            request.getRequestDispatcher("/admin/view-user-details.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new ServletException("Server error", e);
        }
    }
}
