package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.DB.LoginDAO;
import org.example.model.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/signup2")
public class SignUp2Servlet extends HttpServlet {
    LoginDAO loginDAO=new LoginDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        String name=request.getParameter("name");
        String phone_num=request.getParameter("phone_num");
        String role= session.getAttribute("userRole").toString();
        int report_to= request.getParameter("report-to")==null?0:Integer.parseInt(request.getParameter("report-to"));

        String email= session.getAttribute("email").toString();
        String password= session.getAttribute("password").toString();

        String CHECK_ADMIN_ID="SELECT * FROM emp_password_manager WHERE emp_id=? AND role=?";
        try(Connection conn=loginDAO.newConnection();
            PreparedStatement stmt=conn.prepareStatement(CHECK_ADMIN_ID)){
            stmt.setInt(1,report_to);
            stmt.setString(2,role);
            ResultSet rs=stmt.executeQuery();
            if(rs.next()){
                request.setAttribute("errorMessage","Invalid Admin ID");
                request.getRequestDispatcher("/sign-up2.jsp").forward(request,response);
                return ;
            }
            conn.setAutoCommit(false);
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


            if(role.equals("user")){
                session.setAttribute("empID",id);
                String ADD_TO_USER_PROFILE_DETAILS="INSERT INTO user_profile_details (emp_id,email,report_to,name,phone_num,role) VALUES (?,?,?,?,?,?)";
                PreparedStatement query4=conn.prepareStatement(ADD_TO_USER_PROFILE_DETAILS);
                query4.setInt(1,id);
                query4.setString(2,email);
                query4.setInt(3,report_to);
                query4.setString(4,name);
                query4.setString(5,phone_num);
                query4.setString(6,role);
                query4.executeUpdate();

                User user = new User();
                user.setEmail(email);
                user.setName(name);
                user.setEmploymentId(id);
                user.setReportTo(report_to);
                user.setPhoneNumber(phone_num);

                session.setAttribute("userName",name);
                session.setAttribute("loggedInUser",user);

                response.sendRedirect(request.getContextPath()+"/dashboard");
            }else{
                session.setAttribute("empId",id);
                String ADD_TO_ADMIN_PROFILE_DETAILS="INSERT INTO admin_profile_details (emp_id,email,name,phone_num,role) VALUES (?,?,?,?,?)";
                PreparedStatement query5=conn.prepareStatement(ADD_TO_ADMIN_PROFILE_DETAILS);
                query5.setInt(1,id);
                query5.setString(2,email);
                query5.setString(3,name);
                query5.setString(4,phone_num);
                query5.setString(5,role);
                query5.executeUpdate();
                response.sendRedirect(request.getContextPath()+"/admin");
            }
            conn.commit();

        } catch (SQLException e) {

            throw new RuntimeException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/sign-up2.jsp").forward(request, response);
    }

}
