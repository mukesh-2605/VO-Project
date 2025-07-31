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

@WebServlet("/vendor/tax-info")
public class TaxInfoServlet extends HttpServlet {
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
                vendor.setGSTIN_or_VAT_or_TIN_type(rs.getString("GSTIN_or_VAT_or_TIN_type"));
                vendor.setGSTIN_or_VAT_or_TIN_number(rs.getString("GSTIN_or_VAT_or_TIN_number"));
                vendor.setPAN_number(rs.getString("PAN_number"));
                vendor.setBusiness_licence_number(rs.getString("business_licence_number"));
                request.setAttribute("vendor",vendor);

                request.getRequestDispatcher("/vendor/tax-info.jsp").forward(request,response);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Vendor vendor = (Vendor) session.getAttribute("vendor");
        String GSTIN_or_VAT_or_TIN_type=request.getParameter("GSTIN_or_VAT_or_TIN_type");
        String GSTIN_or_VAT_or_TIN_number=request.getParameter("GSTIN_or_VAT_or_TIN_number");
        String PAN_number=request.getParameter("PAN_number");
        String business_licence_number=request.getParameter("business_licence_number");

        String UDPATE_TAX_INFO_SQL="UPDATE vendor_details SET GSTIN_or_VAT_or_TIN_type=?, GSTIN_or_VAT_or_TIN_number=?, PAN_number=?, business_licence_number=? WHERE id=?";

        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement(UDPATE_TAX_INFO_SQL)){
            query.setString(1,GSTIN_or_VAT_or_TIN_type);
            query.setString(2,GSTIN_or_VAT_or_TIN_number);
            query.setString(3,PAN_number);
            query.setString(4,business_licence_number);

            query.setInt(5,vendor.getId());

            query.executeUpdate();
            response.sendRedirect(request.getContextPath()+"/vendor/bank-info");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
