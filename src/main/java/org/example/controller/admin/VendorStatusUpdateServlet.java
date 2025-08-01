package org.example.controller.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.AdminDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/admin/status/*")
public class VendorStatusUpdateServlet extends HttpServlet {

    private AdminDAO adminDAO = new AdminDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        int id = Integer.parseInt(request.getParameter("id"));
        String remark = request.getParameter("remark");

        try {
            switch (action) {
                case "/deleteVendor":
                    adminDAO.deleteVendor(id);
                    System.out.println("Vendor deleted: " + id);
                    response.sendRedirect(request.getContextPath() + "/admin/vendors");
//                    response.setContentType("text/html");
//                    response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
                    break;
                case "/approveVendor":
                    System.out.println("approving");
                    adminDAO.approveVendor(id);
                    System.out.println("Vendor approved: " + id);
                    response.sendRedirect(request.getContextPath() + "/admin/vendors");
//                    response.setContentType("text/html");
//                    response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
                    break;
                case "/rejectVendor":
                    adminDAO.rejectVendor(id, remark);
                    System.out.println("Vendor rejected: " + id);
                    response.sendRedirect(request.getContextPath() + "/admin/vendors");
//                    response.setContentType("text/html");
//                    response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
                    break;
                case "/requestVendor":
                    adminDAO.requestDataToVendor(id, remark);
                    System.out.println("Vendor requested for data: " + id);
                    response.sendRedirect(request.getContextPath() + "/admin/vendors");
//                    response.setContentType("text/html");
//                    response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
                    break;
                default:
                    //listUser(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        int id = Integer.parseInt(request.getParameter("id"));
        String remark = request.getParameter("remark");

        try {
            switch (action) {
                case "/rejectVendor":
                    adminDAO.rejectVendor(id, remark);
                    System.out.println("Vendor rejected: " + id);
                    response.sendRedirect(request.getContextPath() + "/admin/vendors");
//                    response.setContentType("text/html");
//                    response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
                    break;
                case "/requestVendor":
                    adminDAO.requestDataToVendor(id, remark);
                    System.out.println("Vendor requested for data: " + id);
                    response.sendRedirect(request.getContextPath() + "/admin/vendors");
//                    response.setContentType("text/html");
//                    response.getWriter().write("<script>window.location.replace('" + request.getContextPath() + "/admin/vendors');</script>");
                    break;
                default:
                    //listUser(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }
}
