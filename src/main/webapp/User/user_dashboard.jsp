<%--
  File: user_dashboard.jsp
  Description: A personalized dashboard for a logged-in user (unstyled version).
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  ------------------------------------------------------------------------------------------
  IMPORTANT NOTE FOR DEVELOPER:
  This page assumes a user has already logged in. A login servlet should have set
  attributes in the user's session. For example:

  // In your LoginServlet.java after successful authentication:
  // HttpSession session = request.getSession();
  // session.setAttribute("userName", "Suresh Kumar");
  // session.setAttribute("userId", "E12345");
  // response.sendRedirect("user_dashboard.jsp");
  ------------------------------------------------------------------------------------------
--%>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

    <div>
        <%--
          Using JSP Expression Language (EL) to get attributes from the session.
          ${sessionScope.userName} fetches the "userName" attribute.
        --%>
        <h1>Welcome, <c:out value="${sessionScope.userName}" default="User"/>!</h1>
        <p>This is your personal dashboard. Current time is <%= new java.util.Date() %>.</p>

        <hr>

        <h3>Your Actions</h3>
        <p>
            <a href="user_profile.jsp">View My Profile</a>
        </p>

        <hr>

        <a href="logout">Logout</a>
    </div>

</body>
</html>