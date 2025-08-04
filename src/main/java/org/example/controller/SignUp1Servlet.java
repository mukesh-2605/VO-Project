package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.DB.LoginDAO;
import org.example.DB.VendorDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/signup1")
public class SignUp1Servlet extends HttpServlet {
    LoginDAO loginDAO=new LoginDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String pw=request.getParameter("pw");
        String role=request.getParameter("role");

        if (!password.equals(pw)) {
            System.out.println("entered if");
            request.setAttribute("errorMessage", "Password does not match");
            System.out.println("password mismatch");
            request.getRequestDispatcher("/sign-up1.jsp").forward(request, response);
            return;
        }

        String sql="SELECT * FROM emp_password_manager WHERE email=?";
        String sqll="SELECT * FROM vendor_password_manager WHERE v_email=?";
        try(Connection conn= loginDAO.newConnection();
            PreparedStatement query=conn.prepareStatement(sql);
            PreparedStatement queryy=conn.prepareStatement(sqll)){
            query.setString(1,email);
            queryy.setString(1,email);
            ResultSet rs=query.executeQuery();
            ResultSet rss=queryy.executeQuery();
            if(rs.next() || rss.next()){
                request.setAttribute("errorMessage", "Email already exists");
                request.getRequestDispatcher("/sign-up1.jsp").forward(request, response);
                return ;
            }

            String ADD_TO_PASSWORD_MANAGER="INSERT INTO emp_password_manager (email,password,role) VALUES (?,?,?)";
            PreparedStatement query2= conn.prepareStatement(ADD_TO_PASSWORD_MANAGER);
            query2.setString(1,email);
            query2.setString(2,password);
            query2.setString(3,role);
            query2.executeUpdate();

            String GET_NEW_ID="SELECT emp_id FROM emp_password_manager WHERE email=?";
            PreparedStatement query3= conn.prepareStatement(GET_NEW_ID);
            query3.setString(1,email);
            rs=query3.executeQuery();
            rs.next();
            int id=rs.getInt("emp_id");

            response.sendRedirect(request.getContextPath()+"/signup2?id="+id+"&role="+role);


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/sign-up1.jsp").forward(request, response);
    }
}
