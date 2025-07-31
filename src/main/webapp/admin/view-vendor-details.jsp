<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*, org.example.model.Vendor" %>

<c:set var="test" value="Hello JSTL!" />
<p><c:out value="${test}"/></p>

<html>
<head>
    <title>Vendor Details</title>
</head>
<body>
<h2>Vendor Details</h2>

    <p><strong>Name:</strong> <c:choose>
        <c:when test="${not empty vendor.name}">${vendor.name}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Email:</strong> <c:choose>
        <c:when test="${not empty vendor.mail}">${vendor.mail}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Company Name:</strong> <c:choose>
        <c:when test="${not empty vendor.company_name}">${vendor.company_name}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Category:</strong> <c:choose>
        <c:when test="${not empty vendor.category}">${vendor.category}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Phone Number:</strong> <c:choose>
        <c:when test="${not empty vendor.phone_num}">${vendor.phone_num}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Website:</strong> <c:choose>
        <c:when test="${not empty vendor.website}">${vendor.website}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Payment Terms:</strong> <c:choose>
        <c:when test="${not empty vendor.payment_terms}">${vendor.payment_terms}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <h3>Business Address</h3>

    <p><strong>Country:</strong> <c:choose>
        <c:when test="${not empty vendor.b_country}">${vendor.b_country}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Address:</strong> <c:choose>
        <c:when test="${not empty vendor.b_address}">${vendor.b_address}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>City:</strong> <c:choose>
        <c:when test="${not empty vendor.b_city}">${vendor.b_city}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>State:</strong> <c:choose>
        <c:when test="${not empty vendor.b_state}">${vendor.b_state}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Zipcode:</strong> <c:choose>
        <c:when test="${not empty vendor.b_zipcode}">${vendor.b_zipcode}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <h3>Shipping Address</h3>

    <p><strong>Country:</strong> <c:choose>
        <c:when test="${not empty vendor.s_country}">${vendor.s_country}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Address:</strong> <c:choose>
        <c:when test="${not empty vendor.s_address}">${vendor.s_address}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>City:</strong> <c:choose>
        <c:when test="${not empty vendor.s_city}">${vendor.s_city}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>State:</strong> <c:choose>
        <c:when test="${not empty vendor.s_state}">${vendor.s_state}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Zipcode:</strong> <c:choose>
        <c:when test="${not empty vendor.s_zipcode}">${vendor.s_zipcode}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <h3>Tax Information</h3>

    <p><strong>GSTIN/VAT/TIN Type:</strong> <c:choose>
        <c:when test="${not empty vendor.GSTIN_or_VAT_or_TIN_type}">${vendor.GSTIN_or_VAT_or_TIN_type}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>GSTIN/VAT/TIN Number:</strong> <c:choose>
        <c:when test="${not empty vendor.GSTIN_or_VAT_or_TIN_number}">${vendor.GSTIN_or_VAT_or_TIN_number}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>PAN Number:</strong> <c:choose>
        <c:when test="${not empty vendor.PAN_number}">${vendor.PAN_number}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Business License Number:</strong> <c:choose>
        <c:when test="${not empty vendor.business_licence_number}">${vendor.business_licence_number}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <h3>Bank Details</h3>

    <p><strong>Beneficiary Name:</strong> <c:choose>
        <c:when test="${not empty vendor.beneficiary_name}">${vendor.beneficiary_name}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Bank Name:</strong> <c:choose>
        <c:when test="${not empty vendor.bank_name}">${vendor.bank_name}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Account Number:</strong> <c:choose>
        <c:when test="${not empty vendor.acc_num}">${vendor.acc_num}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Account Type:</strong> <c:choose>
        <c:when test="${not empty vendor.acc_type}">${vendor.acc_type}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Routing Number:</strong> <c:choose>
        <c:when test="${not empty vendor.routing_number}">${vendor.routing_number}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <h3>Contact Person</h3>

    <p><strong>Name:</strong> <c:choose>
        <c:when test="${not empty vendor.contact_person_name}">${vendor.contact_person_name}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Role:</strong> <c:choose>
        <c:when test="${not empty vendor.cp_role}">${vendor.cp_role}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Phone Number:</strong> <c:choose>
        <c:when test="${not empty vendor.cp_phoneNum}">${vendor.cp_phoneNum}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Alternate Phone Number:</strong> <c:choose>
        <c:when test="${not empty vendor.cp_alter_phoneNum}">${vendor.cp_alter_phoneNum}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Email:</strong> <c:choose>
        <c:when test="${not empty vendor.cp_email}">${vendor.cp_email}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Preferred Communication Channel:</strong> <c:choose>
        <c:when test="${not empty vendor.cp_communication_channel}">${vendor.cp_communication_channel}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <h3>Status</h3>

    <p><strong>Onboarding Status:</strong> <c:choose>
        <c:when test="${not empty vendor.status}">${vendor.status}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>

    <p><strong>Admin Remarks:</strong> <c:choose>
        <c:when test="${not empty vendor.remarks}">${vendor.remarks}</c:when>
        <c:otherwise>-</c:otherwise>
    </c:choose></p>
</body>
</html>