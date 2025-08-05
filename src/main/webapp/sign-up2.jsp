<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty requestScope.errorMessage}">
    <p style="color:red;">
        <c:out value="${requestScope.errorMessage}"/>
    </p>
</c:if>
<br><br>

<form action="<%= request.getContextPath() %>/signup2" method="post">
    <label for="name">Name: </label>
    <input type="text" name="name" required />
    <br><br>
    <label for="phone_num">Phone Number: </label>
    <input type="text" name="phone_num" required />
    <br><br>

    <%-- Show extra field only for users (optional with JS) --%>

    <% String role=session.getAttribute("userRole").toString();
        if("user".equals(role)){
        %>
        <div id="userExtra">
            <label for="report-to">Employee ID of Reporting Admin: </label>
            <input type="number" name="report-to" required />
            <br><br>
        </div>
        <% } %>
    <button type="submit">Sign Up</button>
</form>