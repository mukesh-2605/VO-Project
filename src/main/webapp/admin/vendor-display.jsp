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
        List<Vendor> pendingVendors = (List<Vendor>) request.getAttribute("pendingVendors");
        for (Vendor v : pendingVendors) {
    %>
    <tr>
        <td><%= v.getName() != null ? v.getName() : "-" %></td>
        <td><%= v.getMail() %></td>
        <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
        <td>
            <form action="<%= request.getContextPath() %>/processVendor" method="post">
                <input type="hidden" name="id" value="<%= v.getId() %>" />
                <button type="submit">Process</button>
            </form>
        </td>
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
            List<Vendor> requestedVendors = (List<Vendor>) request.getAttribute("requestedVendors");
            for (Vendor v : requestedVendors) {
        %>
        <tr>
            <td><%= v.getName() != null ? v.getName() : "-" %></td>
            <td><%= v.getMail() %></td>
            <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
            <td>
                <form action="<%= request.getContextPath() %>/admin/deleteVendor" method="post">
                    <input type="hidden" name="id" value="<%= v.getId() %>" />
                    <button type="submit">Delete</button>
                </form>
            </td>
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
            List<Vendor> approvedVendors = (List<Vendor>) request.getAttribute("approvedVendors");
            for (Vendor v : approvedVendors) {
        %>
        <tr>
            <td><%= v.getName() != null ? v.getName() : "-" %></td>
            <td><%= v.getMail() %></td>
            <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
            <td>
                <form action="<%= request.getContextPath() %>/processVendor" method="post">
                    <input type="hidden" name="id" value="<%= v.getId() %>" />
                    <button type="submit">Process</button>
                </form>
            </td>
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
            List<Vendor> reviewVendors = (List<Vendor>) request.getAttribute("reviewVendors");
            for (Vendor v : reviewVendors) {
        %>
        <tr>
            <td><%= v.getName() != null ? v.getName() : "-" %></td>
            <td><%= v.getMail() %></td>
            <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
            <td>
                <form action="<%= request.getContextPath() %>/processVendor" method="post">
                    <input type="hidden" name="id" value="<%= v.getId() %>" />
                    <button type="submit">Process</button>
                </form>
            </td>
        </tr>
        <%
            }
        %>
    </table>

</body>
</html>
