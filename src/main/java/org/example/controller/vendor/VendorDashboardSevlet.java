package org.example.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.model.Vendor;

import java.io.IOException;

@WebServlet("/vendor/vendor-dashboard")
public class VendorDashboardSevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        if (session == null || session.getAttribute("userEmail") == null) {
            response.sendRedirect("/login.jsp");
            return;
        }
        Vendor vendor= (Vendor) session.getAttribute("vendor");

        request.setAttribute("vendor",vendor);
        request.getRequestDispatcher("/vendor/vendor-dashboard.jsp").forward(request, response);
    }
}
