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

<h3>Business Address</h3>
<p><strong>Country:</strong> <%= Helper.show(vendor.getB_country()) %></p>
<p><strong>Address:</strong> <%= Helper.show(vendor.getB_address()) %></p>
<p><strong>City:</strong> <%= Helper.show(vendor.getB_city()) %></p>
<p><strong>State:</strong> <%= Helper.show(vendor.getB_state()) %></p>
<p><strong>Zipcode:</strong> <%= Helper.show(vendor.getB_zipcode()) %></p>

<h3>Shipping Address</h3>
<p><strong>Country:</strong> <%= Helper.show(vendor.getS_country()) %></p>
<p><strong>Address:</strong> <%= Helper.show(vendor.getS_address()) %></p>
<p><strong>City:</strong> <%= Helper.show(vendor.getS_city()) %></p>
<p><strong>State:</strong> <%= Helper.show(vendor.getS_state()) %></p>
<p><strong>Zipcode:</strong> <%= Helper.show(vendor.getS_zipcode()) %></p>

<h3>Tax Information</h3>
<p><strong>GSTIN/VAT/TIN Type:</strong> <%= Helper.show(vendor.getGSTIN_or_VAT_or_TIN_type()) %></p>
<p><strong>GSTIN/VAT/TIN Number:</strong> <%= Helper.show(vendor.getGSTIN_or_VAT_or_TIN_number()) %></p>
<p><strong>PAN Number:</strong> <%= Helper.show(vendor.getPAN_number()) %></p>
<p><strong>Business License Number:</strong> <%= Helper.show(vendor.getBusiness_licence_number()) %></p>

<h3>Bank Details</h3>
<p><strong>Beneficiary Name:</strong> <%= Helper.show(vendor.getBeneficiary_name()) %></p>
<p><strong>Bank Name:</strong> <%= Helper.show(vendor.getBank_name()) %></p>
<p><strong>Account Number:</strong> <%= Helper.show(vendor.getAcc_num()) %></p>
<p><strong>Account Type:</strong> <%= Helper.show(vendor.getAcc_type()) %></p>
<p><strong>Routing Number:</strong> <%= Helper.show(vendor.getRouting_number()) %></p>

<h3>Contact Person</h3>
<p><strong>Name:</strong> <%= Helper.show(vendor.getContact_person_name()) %></p>
<p><strong>Role:</strong> <%= Helper.show(vendor.getCp_role()) %></p>
<p><strong>Phone Number:</strong> <%= Helper.show(vendor.getCp_phoneNum()) %></p>
<p><strong>Alternate Phone Number:</strong> <%= Helper.show(vendor.getCp_alter_phoneNum()) %></p>
<p><strong>Email:</strong> <%= Helper.show(vendor.getCp_email()) %></p>
<p><strong>Preferred Communication Channel:</strong> <%= Helper.show(vendor.getCp_communication_channel()) %></p>

<h3>Status</h3>
<p><strong>Onboarding Status:</strong> <%= Helper.show(vendor.getStatus()) %></p>
<p><strong>Admin Remarks:</strong> <%= Helper.show(vendor.getRemarks()) %></p>

</body>
</html>
