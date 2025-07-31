package org.example.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.Constants;
import org.example.DB.VendorDAO;
import org.example.model.Vendor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/vendor/bank-info")
public class BankInfoServlet extends HttpServlet {
    private final VendorDAO vendorDAO=new VendorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Vendor vendor = (Vendor) session.getAttribute("vendor");
        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement("select * from vendor_details where id=?"))   {

            query.setInt(1,vendor.getId());
            ResultSet rs= query.executeQuery();

            if(rs.next()){
                vendor.setBeneficiary_name(rs.getString("beneficiary_name"));
                vendor.setBank_name(rs.getString("bank_name"));
                vendor.setAcc_num(rs.getString("acc_num"));
                vendor.setAcc_type(rs.getString("acc_type"));
                vendor.setRouting_number(rs.getString("routing_number"));

                request.setAttribute("vendor",vendor);
                request.getRequestDispatcher("/vendor/bank-info.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Vendor vendor = (Vendor) session.getAttribute("vendor");
        String beneficiary_name=request.getParameter("beneficiary_name");
        String bank_name=request.getParameter("bank_name");
        String acc_num=request.getParameter("acc_num");
        String acc_type=request.getParameter("acc_type");
        String routing_number=request.getParameter("routing_number");

        String UDPATE_BANK_INFO_SQL="UPDATE vendor_details SET beneficiary_name=?, bank_name=?, acc_num=?, acc_type=?, routing_number=? WHERE id=?";

        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement(UDPATE_BANK_INFO_SQL)){
            query.setString(1,beneficiary_name);
            query.setString(2,bank_name);
            query.setString(3,acc_num);
            query.setString(4,acc_type);
            query.setString(5,routing_number);

            query.setInt(6,vendor.getId());

            query.executeUpdate();
            response.sendRedirect(request.getContextPath()+"/vendor/contact-info");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
