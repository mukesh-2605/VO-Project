<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.User" %>
<%@ page import="org.example.Helper" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>

<%
    User user = (User) request.getAttribute("user");
%>
<html>
<head>
    <title>User Details</title>
</head>
<body>
<h2>User Details</h2>

<p><strong>Name:</strong> <%= Helper.show(user.getName()) %></p>
<p><strong>Email:</strong> <%= Helper.show(user.getEmail()) %></p>
<p><strong>Phone Number:</strong> <%= Helper.show(user.getPhoneNumber()) %></p>
<p><strong>Employment ID:</strong> <%= Helper.showInt(user.getEmploymentId()) %></p>

</body>
</html>
