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
    <input type="text" id="name" name="name" value="<%= vendor != null && vendor.getName()!=null ? vendor.getName() : "" %>" required>
    <br><br>
    <label for="company_name">Company Name:</label>
    <input type="text" id="company_name" name="company_name" value="<%= vendor != null && vendor.getCompany_name()!=null ? vendor.getCompany_name() : "" %>" required>
    <br><br>
    <label for="category">Category of Products:</label>
    <select id="category" name="category" required>
        <option value="" disabled selected>-- Select a Role --</option>
        <option value="Marketing & Creative Agencies">Marketing & Creative Agencies</option>
        <option value="IT & Software Vendors">IT & Software Vendors</option>

    </select>
    <br><br>
    <label for="phone_num">Phone Number:</label>
    <input type="number" id="phone_num" name="phone_num" value="<%= vendor != null && vendor.getPhone_num()!=null ? vendor.getPhone_num() : "" %>" required>
    <br><br>
    <label for="website">website:</label>
    <input type="url" id="website" name="website" value="<%= vendor != null && vendor.getWebsite()!=null ? vendor.getWebsite() : "" %>" required>
    <br><br>
    <label for="payment_terms">Payment Terms:</label>
    <input type="text" id="payment_terms" name="payment_terms" value="<%= vendor != null && vendor.getPayment_terms()!=null ? vendor.getPayment_terms() : "" %>" required>
    <br><br>
    <button type="submit">Save and Next</button>
</form>
<form action="<%= request.getContextPath() %>/vendor/vendor-dashboard.jsp" method="get">
        <button type="submit">Back</button>
</form>
</body>
</html>
