package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.DB.AdminDAO;
import org.example.model.Admin;
import org.example.model.User;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin/profile")
public class Profile extends HttpServlet {
    AdminDAO adminDAO = new AdminDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            //int id = Integer.parseInt(request.getParameter("id"));
            HttpSession httpSession = request.getSession(false);
            Integer id = (Integer) httpSession.getAttribute("empId");
            System.out.println("ID " + id);
            Admin admin = adminDAO.getAdminDetails(id);
            List<User> users = adminDAO.getAllUsers();
            List<Vendor> vendors = adminDAO.getAllVendors();
            request.setAttribute("admin", admin); // Correct
            request.setAttribute("users", users);
            request.setAttribute("vendors", vendors);
            request.getRequestDispatcher("/admin/profile.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("DB error", e);
        }
    }
}
