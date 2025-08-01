package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.VendorDAO;
import org.example.model.User;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

//@WebServlet("/admin/viewVendorDetails")
//public class ViewVendorDetails extends HttpServlet {
//    VendorDAO vendorDAO = new VendorDAO();
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            int id = Integer.parseInt(request.getParameter("id"));
//            //request.setAttribute("vendor", vendorDAO.getVendorDetails(id));
////            Vendor vendor = vendorDAO.getVendorDetails(id);
//            request.setAttribute("vendor", vendor); // Correct
//            System.out.println(vendor.getMail());
//            request.getRequestDispatcher("/admin/view-vendor-details.jsp").forward(request, response);
//        } catch (SQLException e) {
//            throw new ServletException("DB error", e);
//        }
//    }
//}
