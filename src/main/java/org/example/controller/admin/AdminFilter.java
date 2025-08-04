package org.example.controller.admin;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/admin", "/admin/*"})
public class AdminFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("AdminFilter triggered for: " + req.getRequestURI());

        String path = req.getRequestURI();  // full path like /appName/admin/help

        // Exclude specific route
        if (path.endsWith("/admin/viewVendorDetails")) {
            chain.doFilter(request, response); // Skip filter
            return;
        }

        HttpSession session = req.getSession(false);
        if (session != null && session.getAttribute("userEmail") != null) {
            chain.doFilter(request, response);  // allow
        } else {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}


