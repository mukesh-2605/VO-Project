package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.AdminDAO;
import org.example.model.User;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@WebServlet("/admin/display")
public class DisplayServlet extends HttpServlet {
    private AdminDAO adminDAO = new AdminDAO();

    // add new vendor
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        try {
//            switch (action) {
//                case "/new":
//                    showNewForm(request, response);
//                    break;
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Map<String, List<?>> data = adminDAO.getAllVendorsAndUsers();
            List<Vendor> vendorList = (List<Vendor>) data.get("vendors"); // Fetch from DB
            List<User> userList = (List<User>) data.get("users");
            request.setAttribute("vendors", vendorList); // Send to JSP
            request.setAttribute("users", userList);
            request.getRequestDispatcher("/admin-display.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("DB error", e);
        }
    }
}