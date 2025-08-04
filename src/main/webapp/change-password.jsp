<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<c:if test="${not empty requestScope.errorMessage}">
    <p style="color:red;">
        <c:out value="${requestScope.errorMessage}"/>
    </p>
</c:if>

<form action="<%= request.getContextPath() %>/change-password" method="post">
       <label for="password">Enter new Password: </label>
       <input name="password" type="text" required />
       <br><br>
       <label for ="confirm-pw" > Re-enter password: </label>
       <input name="confirm-pw" type="password" required />
       <br><br>
    <button type="submit">Change Password</button>
</form>