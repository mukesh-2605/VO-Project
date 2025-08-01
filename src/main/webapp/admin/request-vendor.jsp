<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>
<!DOCTYPE html>
<html>
<head>
    <title>Request Vendor</title>
</head>
<body>
<h2>Request Vendor Access</h2>
<form action="${pageContext.request.contextPath}/admin/requestVendor" method="post">
    <label for="mail">Vendor Email:</label>
    <input type="email" id="mail" name="mail" required>
    <br><br>
    <button type="submit">Submit Request</button>
</form>
</body>
</html>
