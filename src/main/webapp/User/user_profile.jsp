<%--
  File: user_profile.jsp
  Description: Displays the detailed profile of the logged-in user.
  This page expects a 'user' object to be set in the request scope by a servlet.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Profile</title>
</head>
<body>

    <%--
      This JSTL <c:choose> block checks if the 'user' object exists in the request.
      It's the modern equivalent of an if-else statement.
    --%>
    <c:choose>
        <%-- The 'when' block executes if 'user' is NOT empty. --%>
        <c:when test="${not empty requestScope.user}">
            <h2>User Profile</h2>
            <%--
              Using Expression Language (EL) to access the User object's properties.
              Example: ${user.name} calls the user.getName() method.
              The <c:out> tag is used for security to prevent XSS attacks.
            --%>
            <p><strong>Name:</strong> <c:out value="${user.name}"/></p>
            <p><strong>Email:</strong> <c:out value="${user.email}"/></p>
            <p><strong>Phone Number:</strong> <c:out value="${user.phoneNumber}"/></p>
            <p><strong>Role:</strong> <c:out value="${user.role}"/></p>
            <p><strong>Employment ID:</strong> <c:out value="${user.employmentId}"/></p>
        </c:when>

        <%-- The 'otherwise' block executes if 'user' was not found in the request. --%>
        <c:otherwise>
            <h2>No User Data Found</h2>
            <p>Could not retrieve user profile information. Please try again later.</p>
        </c:otherwise>
    </c:choose>

    <hr>
    <a href="user_dashboard.jsp">Back to Dashboard</a>

</body>
</html>