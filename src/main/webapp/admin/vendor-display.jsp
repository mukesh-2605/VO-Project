<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.example.model.Vendor" %>
<%@ page import="java.util.*, org.example.model.User" %>

<html>
<head>
    <title>Vendor List</title>
</head>
<body>
<h2>Pending Vendors</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Company</th>
    </tr>
    <%
        List<Vendor> vendors = (List<Vendor>) request.getAttribute("pendingVendors");
        for (Vendor v : vendors) {
    %>
    <tr>
        <td><%= v.getName() %></td>
        <td><%= v.getMail() %></td>
        <td><%= v.getCompany() %></td>
    </tr>
    <%
        }
    %>
    </table>

    <h2>Requested Vendors</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Company</th>
        </tr>

    <%
            List<Vendor> vendors = (List<Vendor>) request.getAttribute("requestedVendors");
            for (Vendor v : vendors) {
        %>
        <tr>
            <td><%= v.getName() %></td>
            <td><%= v.getEmail() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <h2>Approved Vendors</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Company</th>
        </tr>
        <%
            List<Vendor> vendors = (List<Vendor>) request.getAttribute("approvedVendors");
            for (Vendor v : vendors) {
        %>
        <tr>
            <td><%= v.getName() %></td>
            <td><%= v.getMail() %></td>
            <td><%= v.getCompany() %></td>
        </tr>
        <%
            }
        %>
    </table>

    <h2>Review Vendors</h2>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Company</th>
        </tr>
        <%
            List<Vendor> vendors = (List<Vendor>) request.getAttribute("reviewVendors");
            for (Vendor v : vendors) {
        %>
        <tr>
            <td><%= v.getName() %></td>
            <td><%= v.getMail() %></td>
            <td><%= v.getCompany() %></td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
