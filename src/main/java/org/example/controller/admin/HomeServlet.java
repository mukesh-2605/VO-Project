package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/admin")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
        } catch (ServletException e) {
            throw new ServletException("Servlet error", e);
        }
    }
}
