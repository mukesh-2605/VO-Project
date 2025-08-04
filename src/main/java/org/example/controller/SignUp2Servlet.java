package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.LoginDAO;

import java.io.IOException;

@WebServlet("/signup2")
public class SignUp2Servlet extends HttpServlet {
    LoginDAO loginDAO=new LoginDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String phone_num=request.getParameter("phone_num");
        String role=request.getParameter("role");
        String report_to=request.getParameter("report-to");

        if(role.equals("user")){

        }else{

        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/sign-up1.jsp").forward(request, response);
    }

}
