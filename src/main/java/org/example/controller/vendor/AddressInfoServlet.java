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

@WebServlet("/vendor/address-info")
public class AddressInfoServlet extends HttpServlet {
    private final VendorDAO vendorDAO=new VendorDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Vendor vendor=null;
        int id;
        if(session.getAttribute("userRole").equals("vendor")){
            vendor = (Vendor) session.getAttribute("vendor");
            id= vendor.getId();
        }else{
            vendor=new Vendor();
            id= (int) session.getAttribute("vid");
        }        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement("select * from vendor_details where id=?"))   {

            query.setInt(1,id);
            ResultSet rs= query.executeQuery();

            if(rs.next()){
                vendor.setB_country(rs.getString("b_country"));
                vendor.setB_address(rs.getString("b_address"));
                vendor.setB_city(rs.getString("b_city"));
                vendor.setB_state(rs.getString("b_state"));
                vendor.setB_zipcode(rs.getString("b_zipcode"));

                vendor.setS_country(rs.getString("s_country"));
                vendor.setS_address(rs.getString("s_address"));
                vendor.setS_city(rs.getString("s_city"));
                vendor.setS_state(rs.getString("s_state"));
                vendor.setS_zipcode(rs.getString("s_zipcode"));

                request.setAttribute("vendor",vendor);
                request.getRequestDispatcher("/vendor/address-info.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession(false);
        Vendor vendor=null;
        int id;
        if(session.getAttribute("userRole").equals("vendor")){
            vendor = (Vendor) session.getAttribute("vendor");
            id= vendor.getId();
        }else{
            vendor=new Vendor();
            id= (int) session.getAttribute("vid");
        }        String b_country=request.getParameter("b_country");
        String b_address=request.getParameter("b_address");
        String b_city=request.getParameter("b_city");
        String b_state=request.getParameter("b_state");
        String b_zipcode=request.getParameter("b_zipcode");

        String s_country=request.getParameter("s_country");
        String s_address=request.getParameter("s_address");
        String s_city=request.getParameter("s_city");
        String s_state=request.getParameter("s_state");
        String s_zipcode=request.getParameter("s_zipcode");

        String UDPATE_ADDRESS_INFO_SQL="UPDATE vendor_details SET b_country=?, b_address=?, b_city=?, b_state=?, b_zipcode=?, "
                + "s_country=?, s_address=?, s_city=?, s_state=?, s_zipcode=? WHERE id=?";

        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement(UDPATE_ADDRESS_INFO_SQL)){
            query.setString(1,b_country);
            query.setString(2,b_address);
            query.setString(3,b_city);
            query.setString(4,b_state);
            query.setString(5,b_zipcode);

            query.setString(6,s_country);
            query.setString(7,s_address);
            query.setString(8,s_city);
            query.setString(9,s_state);
            query.setString(10,s_zipcode);
            query.setInt(11,id);

            query.executeUpdate();
            response.sendRedirect(request.getContextPath()+"/vendor/tax-info");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
