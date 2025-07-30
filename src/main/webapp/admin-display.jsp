<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.example.model.Vendor" %>
<%@ page import="java.util.*, org.example.model.User" %>

<html>
<head>
    <title>Vendor List</title>
</head>
<body>
<h2>Vendors</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <%
        List<Vendor> vendors = (List<Vendor>) request.getAttribute("vendors");
        for (Vendor v : vendors) {
    %>
    <tr>
        <td><%= v.getName() %></td>
        <td><%= v.getMail() %></td>
    </tr>
    <%
        }
    %>

    <%
            List<User> users = (List<User>) request.getAttribute("users");
            for (User u : users) {
        %>
        <tr>
            <td><%= u.getName() %></td>
            <td><%= u.getMail() %></td>
        </tr>
        <%
            }
        %>
</table>
</body>
</html>
