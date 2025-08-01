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
import org.json.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

@WebServlet("/vendor/other-info")
public class OtherInfoServlet extends HttpServlet {
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
                vendor.setOther_details(rs.getString("other_details"));

                request.setAttribute("vendor",vendor);
                request.getRequestDispatcher("/vendor/other-info.jsp").forward(request,response);
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
        }
        JSONObject updatedExtraInfo = new JSONObject();
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String param = paramNames.nextElement();
            String value = request.getParameter(param);
            updatedExtraInfo.put(param, value);
        }

        String querySQL="UPDATE vendor_details SET other_details=?,status=? WHERE id=?";
        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement(querySQL))   {
            query.setString(1,updatedExtraInfo.toString());
            query.setString(2,"Pending");
            query.setInt(3,id);
            query.executeUpdate();
            if(session.getAttribute("userRole").equals("vendor")){
                response.sendRedirect(request.getContextPath()+"/vendor/vendor-dashboard.jsp");
            }else{
                response.sendRedirect(request.getContextPath()+"/User/user_dashboard.jsp");
            }
            vendor.setOther_details(updatedExtraInfo.toString());
            vendor.setStatus("Pending");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
