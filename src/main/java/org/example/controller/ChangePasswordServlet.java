package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.DB.LoginDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@WebServlet("/change-password")
public class ChangePasswordServlet extends HttpServlet {
    LoginDAO loginDAO=new LoginDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/change-password.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        String password=request.getParameter("password");
        String pw=request.getParameter("confirm-pw");

        if(!password.equals(pw)){
            request.setAttribute("errorMessage","Password mismatch");
            request.getRequestDispatcher("/change-password.jsp").forward(request,response);
            return ;
        }

        String role= session.getAttribute("userRole").toString();


        if(role.equals("admin")){
            int emp_id= (int) session.getAttribute("empId");
            String ADMIN_SQL="UPDATE emp_password_manager SET password=? WHERE emp_id=?";
            try(Connection conn=loginDAO.newConnection();
                PreparedStatement stmt=conn.prepareStatement(ADMIN_SQL)){
                stmt.setString(1,password);
                stmt.setInt(2,emp_id);
                stmt.executeUpdate();
                //request.getRequestDispatcher("/admin").forward(request,response);
                response.sendRedirect(request.getContextPath()+"/admin/home.jsp");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else if (role.equals("user")){
            int emp_id= (int) session.getAttribute("empId");
            String USER_SQL="UPDATE emp_password_manager SET password=? WHERE emp_id=?";
            try(Connection conn=loginDAO.newConnection();
                PreparedStatement stmt=conn.prepareStatement(USER_SQL)){
                stmt.setString(1,password);
                stmt.setInt(2,emp_id);
                stmt.executeUpdate();
                response.sendRedirect(request.getContextPath()+"/user/user_dashboard.jsp");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }else{
            int id= (int) session.getAttribute("id");
            String VENDOR_SQL="UPDATE vendor_password_manager SET password=? WHERE id=?";
            try(Connection conn=loginDAO.newConnection();
                PreparedStatement stmt=conn.prepareStatement(VENDOR_SQL)){
                stmt.setString(1,password);
                stmt.setInt(2,id);
                stmt.executeUpdate();
                response.sendRedirect(request.getContextPath()+"/vendor/vendor-dashboard.jsp");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
