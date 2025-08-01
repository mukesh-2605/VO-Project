<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.example.model.Vendor" %>
<%@ page import="java.util.*, org.example.model.User" %>
<%@ page import="java.util.*, org.example.model.Admin" %>
<%@ page import="org.example.Helper" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>
<%
    Admin admin = (Admin) request.getAttribute("admin");
%>
<html>
<head>
    <title>Admin Profile</title>
</head>
<body>

<script>
    function goToVendorDetails(vendorId, email) {
        const url = '<%= request.getContextPath() %>/admin/viewVendorDetails?id=' + vendorId;
        window.location.href = url;
    }
</script>

<script>
    function goToUserDetails(userId, email) {
        const url = '<%= request.getContextPath() %>/userProfile?id=' + userId;
        window.location.href = url;
    }
</script>

<p><strong>Name:</strong> <%= Helper.show(admin.getName()) %></p>
<p><strong>Email:</strong> <%= Helper.show(admin.getMail()) %></p>
<p><strong>Employee ID:</strong> <%= Helper.showInt(admin.getEmployment_id()) %></p>
<p><strong>Phone Number:</strong> <%= Helper.show(admin.getPhoneNum()) %></p>

<h2>Vendors</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Company</th>
    </tr>
    <%
        List<Vendor> vendors = (List<Vendor>) request.getAttribute("vendors");
        for (Vendor v : vendors) {
    %>
    <tr style="cursor: pointer;" onclick="goToVendorDetails('<%= v.getId() %>', '<%= v.getMail() %>')">
        <td><%= v.getName() != null ? v.getName() : "-" %></td>
        <td><%= v.getMail() %></td>
        <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
    </tr>
    <%
        }
    %>
    </table>

    <h2>Users</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
        </tr>

    <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User u : users) {
        %>
        <tr style="cursor: pointer;" onclick="goToUserDetails('<%= u.getId() %>', '<%= u.getEmail() %>')">
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
        </tr>
        <%
            }
        %>
</table>
</body>
</html>
