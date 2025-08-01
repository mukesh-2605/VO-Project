package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/logout")
public class LogoutSevlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false); // Get the existing session, don't create a new one if none exists

        if (session != null) {
            session.invalidate(); // Invalidate the session, destroying all its attributes
            System.out.println("Session invalidated successfully.");
        } else {
            System.out.println("No active session to invalidate.");
        }

        // Redirect to a login page or home page after logout
        response.sendRedirect("login.jsp"); // Or any other appropriate page
    }
}
