<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Vendor" %>
<%
    Vendor vendor = (Vendor) request.getAttribute("vendor");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Vendor Business Info</title>
</head>
<body>
<h2>Business Info</h2>
<form action="<%= request.getContextPath() %>/vendor/business-info" method="post">
    <label for="name">Primary Contact Person Name: </label>
    <input type="text" id="name" name="name" value="<%= vendor != null ? vendor.getName() : "" %>" required>
    <br><br>
    <label for="company_name">Company Name:</label>
    <input type="text" id="company_name" name="company_name" value="<%= vendor != null ? vendor.getCompany_name() : "" %>" required>
    <br><br>
    <label for="category">Category of Products:</label>
    <input type="text" id="category" name="category" value="<%= vendor != null ? vendor.getCategory() : "" %>" required>
    <br><br>
    <label for="phone_num">Phone Number:</label>
    <input type="number" id="phone_num" name="phone_num" value="<%= vendor != null ? vendor.getPhone_num() : "" %>" required>
    <br><br>
    <label for="website">website:</label>
    <input type="url" id="website" name="website" value="<%= vendor != null ? vendor.getWebsite() : "" %>" required>
    <br><br>
    <label for="payment_terms">Payment Terms:</label>
    <input type="text" id="payment_terms" name="payment_terms" value="<%= vendor != null ? vendor.getPayment_terms() : "" %>" required>
    <br><br>
    <button type="submit">Save and Next</button>
</form>
</body>
</html>
