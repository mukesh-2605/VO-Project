package org.example.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.Constants;
import org.example.DB.VendorDAO;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/vendor/business-info")
public class BusinessInfoServlet extends HttpServlet {
    private final VendorDAO vendorDAO=new VendorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String email=Constants.email;
        Vendor vendor=null;
        try(Connection connection= vendorDAO.newConnection();
            PreparedStatement query=connection.prepareStatement("select * from vendorDetails where v_email=?")){

            query.setString(1,Constants.email);
            ResultSet rs=query.executeQuery();

            if(rs.next()){
                String name=rs.getString("v_name");
                String c_name=rs.getString("company_name");
                String category=rs.getString("category");
                int p_num=rs.getInt("phone_num");
                String website=rs.getString("website");
                String payment_terms=rs.getString("payment_terms");
                vendor=new Vendor(name,c_name,category,p_num,website,payment_terms);

                request.setAttribute("vendor",vendor);
                request.getRequestDispatcher("vendor/business-info.jsp").forward(request,response);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email= Constants.email;
        String name=request.getParameter("name");
        String company_name=request.getParameter("company_name");
        String category=request.getParameter("category");
        String phone_num=request.getParameter("phone_num");
        String website=request.getParameter("website");
        String payment_terms=request.getParameter("payment_terms");
        String UDPATE_BUSINESS_INFO_SQL="UPDATE vendorDetails SET v_name=?, company_name=?,category=? ,"+
                " phone_num=?,website=?, payment_terms=? WHERE v_email=?";

        try(Connection connection= vendorDAO.newConnection();
            PreparedStatement pstmt=connection.prepareStatement(UDPATE_BUSINESS_INFO_SQL)
            ){
            pstmt.setString(1,name);
            pstmt.setString(2,company_name);
            pstmt.setString(3,category);
            pstmt.setString(4,phone_num);
            pstmt.setString(5,website);
            pstmt.setString(6,payment_terms);
            pstmt.setString(7,email);
            pstmt.executeUpdate();
            response.sendRedirect(request.getContextPath()+"/vendor/address-info");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
