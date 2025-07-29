package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.AdminDAO;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;

//@WebServlet("/admin/requestVendor")
public class DisplayServlet extends HttpServlet {
    private AdminDAO adminDAO = new AdminDAO();

    // add new vendor
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("request-vendor.jsp").forward(request, response);
    }
}