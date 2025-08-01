<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Invite New Vendor</title>
</head>
<body>

    <h2>Invite a New Vendor</h2>
    <p>Enter the new vendor's email and a temporary password. They can change this password later.</p>

    <c:if test="${not empty requestScope.errorMessage}">
        <p><c:out value="${requestScope.errorMessage}"/></p>
    </c:if>
    <c:if test="${not empty requestScope.successMessage}">
        <p><c:out value="${requestScope.successMessage}"/></p>
    </c:if>


    <form action="${pageContext.request.contextPath}/inviteVendor" method="post">
        <div>
            <label for="vendorEmail">Vendor's Email:</label><br>
            <input type="email" id="vendorEmail" name="vendorEmail" required>
        </div>
        <br>
        <div>
            <label for="vendorPassword">Temporary Password:</label><br>
            <input type="password" id="vendorPassword" name="vendorPassword" required>
        </div>
        <br>
        <div>
            <button type="submit">Create Vendor and Continue</button>
        </div>
    </form>

    <hr>
    <a href="${pageContext.request.contextPath}/dashboard">Back to Dashboard</a>

</body>
</html>
