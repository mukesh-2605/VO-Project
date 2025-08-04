<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>

<!DOCTYPE html>
<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <h2>Hello Admin</h2>

    <form action="<%= request.getContextPath() %>/admin/requestVendor" method="get">
            <button type="submit">Invite Vendor</button>
        </form>

        <form action="<%= request.getContextPath() %>/admin/vendors" method="get">
            <button type="submit">View Vendors</button>
        </form>

        <form action="<%= request.getContextPath() %>/admin/profile" method="get">
            <button type="submit">View Profile</button>
        </form>

        <form action="<%= request.getContextPath() %>/change-password" method="get">
            <button type="submit">Change Password</button>
        </form>

        <form action="<%= request.getContextPath() %>/logout" method="get">
            <button type="submit">logout</button>
        </form>
</body>
</html>
