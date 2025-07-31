<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

    <div>
        <h2>Login to Your Account</h2>


        <c:if test="${not empty requestScope.errorMessage}">
            <p style="color:red;">
                <c:out value="${requestScope.errorMessage}"/>
            </p>
        </c:if>

        <%-- The form submits the data to a "login" servlet using the POST method. --%>
        <form action="login" method="post">
            <div>
                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" required>
            </div>
            <br>
            <div>
                <label for="password">Password:</label><br>
                <input type="password" id="password" name="password" required>
            </div>
            <br>
            <div>
                <label for="role">Login as:</label><br>
                <select id="role" name="role" required>
                    <option value="" disabled selected>-- Select a Role --</option>
                    <option value="admin">Admin</option>
                    <option value="user">User</option>
                    <option value="vendor">Vendor</option>
                </select>
            </div>
            <br>
            <div>
                <button type="submit">Login</button>
            </div>
        </form>
    </div>

</body>
</html>
