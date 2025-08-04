<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h3>Sign up</h3>


<div>
<c:if test="${not empty requestScope.errorMessage}">
    <p style="color:red;">
        <c:out value="${requestScope.errorMessage}"/>
    </p>
</c:if>
</div>
<form action="signup1" method="post">

    <label for="email">Email: </label>
    <input type="email" name="email" required />
    <br><br>
    <label for="password">Password: </label>
    <input type="text" name="password" required />
    <br><br>
    <label for="pw">Confirm Password: </label>
    <input type="password" name="pw" required />
    <br><br>

    <label for="role">Role: </label>
    <select name="role" required>
        <option value="" disabled selected>-- Select a Role --</option>
        <option value="user">User</option>
        <option value="admin">Admin</option>
    </select>
    <br><br>
    <button type="submit">Sign Up</button>
</form>