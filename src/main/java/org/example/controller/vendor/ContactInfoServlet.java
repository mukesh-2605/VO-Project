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

@WebServlet("/vendor/contact-info")
public class ContactInfoServlet extends HttpServlet {
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
                vendor.setContact_person_name(rs.getString("cp_name"));
                vendor.setCp_role(rs.getString("cp_role"));
                vendor.setCp_phoneNum(rs.getString("cp_phone_num"));
                vendor.setCp_alter_phoneNum(rs.getString("cp_alter_phone_num"));
                vendor.setCp_email(rs.getString("cp_email"));
                vendor.setCp_communication_channel(rs.getString("cp_communication_channel"));
                request.setAttribute("vendor",vendor);
                request.getRequestDispatcher("/vendor/contact-info.jsp").forward(request,response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
        }
        String contact_person_name=request.getParameter("contact_person_name");
        String cp_role=request.getParameter("cp_role");
        String cp_phoneNum=request.getParameter("cp_phoneNum");
        String cp_alter_phoneNum=request.getParameter("cp_alter_phoneNum");
        String cp_email=request.getParameter("cp_email");
        String cp_communication_channel=request.getParameter("cp_communication_channel");

        String UDPATE_CONTACT_INFO_SQL="UPDATE vendor_details SET cp_name=?, cp_role=?, cp_phone_num=?, cp_alter_phone_num=?"
                +",cp_email=?,cp_communication_channel=? WHERE id=?";

        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement(UDPATE_CONTACT_INFO_SQL)){
            query.setString(1,contact_person_name);
            query.setString(2,cp_role);
            query.setString(3,cp_phoneNum);
            query.setString(4,cp_alter_phoneNum);
            query.setString(5,cp_email);
            query.setString(6,cp_communication_channel);
            query.setInt(7,id);

            query.executeUpdate();
            response.sendRedirect(request.getContextPath()+"/vendor/other-info");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
