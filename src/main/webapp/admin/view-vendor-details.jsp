<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.example.model.Vendor" %>
<%@ page import="org.example.Helper" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>

<%
        Vendor vendor = (Vendor) request.getAttribute("vendor");
%>
<html>
<head>
    <title>Vendor Details</title>
</head>
<body>
<h2>Vendor Details</h2>

<p><strong>Name:</strong> <%= Helper.show(vendor.getName()) %></p>
<p><strong>Email:</strong> <%= Helper.show(vendor.getMail()) %></p>
<p><strong>Company Name:</strong> <%= Helper.show(vendor.getCompany_name()) %></p>
<p><strong>Category:</strong> <%= Helper.show(vendor.getCategory()) %></p>
<p><strong>Phone Number:</strong> <%= Helper.show(vendor.getPhone_num()) %></p>
<p><strong>Website:</strong> <%= Helper.show(vendor.getWebsite()) %></p>
<p><strong>Payment Terms:</strong> <%= Helper.show(vendor.getPayment_terms()) %></p>

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

<h2>Extra Info</h2>
<%
    String other_details_Json = vendor.getOther_details();
    if (other_details_Json != null && !other_details_Json.trim().isEmpty()){
        JSONObject json = new JSONObject(other_details_Json);
            Iterator<String> keys = json.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                String value = json.optString(key, "-");
%>
                <p><strong><%= key %>: </strong> <%= value %></p>
<%
            }
    }else {
        System.out.println("<p>No additional information available.</p>");
    }
%>

</body>
</html>
