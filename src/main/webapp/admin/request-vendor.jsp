<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
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
