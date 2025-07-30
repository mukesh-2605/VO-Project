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

@WebServlet("/vendor/submit-business-info")
public class BusinessInfoServlet extends HttpServlet {
    private VendorDAO vendorDAO=new VendorDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("business-info.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email= Constants.email;
        String name=req.getParameter("name");
        String company_name=req.getParameter("company_name");
        String category=req.getParameter("category");
        String phone_num=req.getParameter("phone_num");
        String website=req.getParameter("website");
        String payment_terms=req.getParameter("payment_terms");
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
            resp.sendRedirect("address-info.jsp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
