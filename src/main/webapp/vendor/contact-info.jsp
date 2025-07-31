<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Vendor" %>
<%
    Vendor vendor = (Vendor) request.getAttribute("vendor");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Contact Info</title>
</head>
<body>
<h2>Contact Person Info</h2>
<form action="<%= request.getContextPath() %>/vendor/contact-info" method="post">
    <label for="contact_person_name">contact_person_name: </label>
    <input type="text" id="contact_person_name" name="contact_person_name" value="<%= vendor != null && vendor.getContact_person_name()!=null ? vendor.getContact_person_name() : "" %>" required>
    <br><br>
    <label for="cp_role">cp_role:</label>
    <input type="text" id="cp_role" name="cp_role" value="<%= vendor != null && vendor.getCp_role()!=null ? vendor.getCp_role() : "" %>" required>
    <br><br>
    <label for="cp_phoneNum">cp_phoneNum:</label>
    <input type="text" id="cp_phoneNum" name="cp_phoneNum" value="<%= vendor != null && vendor.getCp_phoneNum()!=null ? vendor.getCp_phoneNum() : "" %>" required>
    <br><br>
    <label for="cp_alter_phoneNum">cp_alter_phoneNum Number:</label>
    <input type="text" id="cp_alter_phoneNum" name="cp_alter_phoneNum" value="<%= vendor != null && vendor.getCp_alter_phoneNum()!=null ? vendor.getCp_alter_phoneNum() : "" %>" required>
    <br><br>
    <label for="cp_email">cp_email:</label>
    <input type="text" id="cp_email" name="cp_email" value="<%= vendor != null && vendor.getCp_email()!=null ? vendor.getCp_email() : "" %>" required>
    <br><br>
    <label for="cp_communication_channel">cp_communication_channel Number:</label>
    <input type="text" id="cp_communication_channel" name="cp_communication_channel" value="<%= vendor != null && vendor.getCp_communication_channel()!=null ? vendor.getCp_communication_channel() : "" %>" required>
    <br><br>
    <button type="submit">Save and Next</button>
</form>
<form action="<%= request.getContextPath() %>/vendor/bank-info" method="get">
      <button type="submit">Back</button>
</form>
</body>
</html>
