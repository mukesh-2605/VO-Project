package org.example.controller.vendor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    private final String email= Constants.email;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Vendor vendor =new Vendor();
        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement("select * from vendor_details where v_email=?"))   {

            query.setString(1,email);
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
        JSONObject updatedExtraInfo = new JSONObject();
        Enumeration<String> paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
            String param = paramNames.nextElement();
            String value = request.getParameter(param);
            updatedExtraInfo.put(param, value);
        }

        String querySQL="UPDATE vendor_details SET other_details=? WHERE v_email=?";
        try(Connection conn= vendorDAO.newConnection();
            PreparedStatement query= conn.prepareStatement(querySQL))   {
            query.setString(1,updatedExtraInfo.toString());
            query.setString(2,email);
            ResultSet rs= query.executeQuery();
            response.sendRedirect(request.getContextPath()+"/vendor/contact-info");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
