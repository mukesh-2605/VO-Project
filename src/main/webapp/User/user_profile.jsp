<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
</head>
<body>

    <c:choose>
        <c:when test="${not empty requestScope.user}">
            <h2>User Profile</h2>

            <p><strong>Email:</strong> <c:out value="${user.email}"/></p>
            <p><strong>Name:</strong> <c:out value="${user.name}"/></p>
            <p><strong>Phone Number:</strong> <c:out value="${user.phoneNumber}"/></p>
            <p><strong>Role:</strong> <c:out value="${user.role}"/></p>
            <p><strong>Employment ID:</strong> <c:out value="${user.employmentId}"/></p>
            <p><strong>Admin ID:</strong> <c:out value="${user.reportTo}"/></p>

        </c:when>

        <c:otherwise>
            <h2>No User Data Found</h2>
            <p>Could not retrieve user profile information. Please try again later.</p>
        </c:otherwise>
    </c:choose>
    <hr>
    <a href="${pageContext.request.contextPath}/change-password">Change Password</a>
    <hr>
    <a href="dashboard">Back to Dashboard</a>

</body>
</html>