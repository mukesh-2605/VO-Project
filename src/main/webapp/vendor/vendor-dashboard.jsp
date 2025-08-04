<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Vendor" %>
<%
    Integer id=(Integer) session.getAttribute("id");
%>

<form action="<%= request.getContextPath() %>/vendor/business-info" method="get">
    <p>Fill details and submit to be approved by admin, click below button to fill details</p>
    <button type="submit">Onboard Vendor</button>
</form>
<% if (id != null) { %>
    <form action="<%= request.getContextPath() %>/admin/viewVendorDetails" method="get">
        <button type="submit">View Vendor info</button>
    </form>
<% } %>

<form action="<%= request.getContextPath() %>/change-password" method="get">
    <button type="submit">Change Password</button>
</form>



<form action="<%= request.getContextPath() %>/logout" method="get">
    <button type="submit">logout</button>
</form>