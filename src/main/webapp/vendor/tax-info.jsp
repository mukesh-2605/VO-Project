<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Vendor" %>
<%
    Vendor vendor = (Vendor) request.getAttribute("vendor");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Vendor Tax Info</title>
</head>
<body>
<h2>Tax Info</h2>
<form action="<%= request.getContextPath() %>/vendor/tax-info" method="post">
    <label for="GSTIN_or_VAT_or_TIN_type">GSTIN / VAT / TIN Type: </label>
    <input type="text" id="GSTIN_or_VAT_or_TIN_type" name="GSTIN_or_VAT_or_TIN_type" value="<%= vendor != null && vendor.getGSTIN_or_VAT_or_TIN_type()!=null ? vendor.getGSTIN_or_VAT_or_TIN_type() : "" %>" required>
    <br><br>
    <label for="GSTIN_or_VAT_or_TIN_number">GSTIN / VAT / TIN Number:</label>
    <input type="text" id="GSTIN_or_VAT_or_TIN_number" name="GSTIN_or_VAT_or_TIN_number" value="<%= vendor != null && vendor.getGSTIN_or_VAT_or_TIN_number()!=null ? vendor.getGSTIN_or_VAT_or_TIN_number() : "" %>" required>
    <br><br>
    <label for="PAN_number">PAN card number:</label>
    <input type="text" id="PAN_number" name="PAN_number" value="<%= vendor != null && vendor.getPAN_number()!=null ? vendor.getPAN_number() : "" %>" required>
    <br><br>
    <label for="business_licence_number">Business Licence Number:</label>
    <input type="text" id="business_licence_number" name="business_licence_number" value="<%= vendor != null && vendor.getBusiness_licence_number()!=null ? vendor.getBusiness_licence_number() : "" %>" required>
    <br><br>
    <button type="submit">Save and Next</button>
</form>
<form action="<%= request.getContextPath() %>/vendor/address-info" method="get">
      <button type="submit">Back</button>
</form>
</body>
</html>
