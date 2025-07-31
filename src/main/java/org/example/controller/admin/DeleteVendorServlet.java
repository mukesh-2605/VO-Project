package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.AdminDAO;
import org.example.DB.VendorDAO;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/deleteVendor")
public class DeleteVendorServlet extends HttpServlet {
    private AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            adminDAO.deleteVendor(id);
            System.out.println("Vendor requested: " + id);
            response.sendRedirect(request.getContextPath() + "/admin/vendors");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
