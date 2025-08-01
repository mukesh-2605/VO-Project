package org.example.controller.admin;

/* *
 *
 * @author Java Programming with Aldrin
 */

import org.example.DB.AdminDAO;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.example.model.Vendor;

@WebServlet("/admin/requestVendor")
public class RequestVendorServlet extends HttpServlet {
    private AdminDAO adminDAO =new AdminDAO();

    // add new vendor
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String mail = request.getParameter("mail");
        String password = mail;
        Vendor newVendor = new Vendor(mail, password);
        try {
            adminDAO.requestNewVendor(mail);
            System.out.println("Vendor requested: " + mail);
            //response.sendRedirect(request.getContextPath() + "/admin");
            response.setContentType("text/html");
            response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/admin/request-vendor.jsp").forward(request, response);
    }
}