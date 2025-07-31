<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <div>
        <%-- CORRECTED: Get the name from the loggedInUser object in the session --%>
        <h1>Welcome, <c:out value="${sessionScope.userEmail}" default="[Not Found]"/>!</h1>

        <p>This is your personal dashboard.</p>
        <hr>

        <%-- The rest of your JSP code remains the same... --%>

        <h3>Your Actions</h3>
        <p><a href="${pageContext.request.contextPath}/userProfile">View My Profile</a></p>
        <hr>

        <h2>Approved Vendors</h2>
        <table border="1" cellpadding="5" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr>
                    <th>Vendor Name</th>
                    <th>Contact Email</th>
                    <th>Company Name</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty approvedVendorList}">
                        <c:forEach var="vendor" items="${approvedVendorList}">
                            <tr>
                                <td><c:out value="${vendor.name}"/></td>
                                <td><c:out value="${vendor.email}"/></td>
                                <td><c:out value="${vendor.company_name}"/></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="3">No approved vendors found at this time.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>

        <hr>

        <h2>Pending Approvals</h2>
        <table border="1" cellpadding="5" style="width: 100%; border-collapse: collapse;">
             <thead>
                <tr>
                    <th>Vendor Name</th>
                    <th>Contact Email</th>
                    <th>Company Name</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty pendingVendorList}">
                        <c:forEach var="vendor" items="${pendingVendorList}">
                            <tr>
                                <td><c:out value="${vendor.name}"/></td>
                                <td><c:out value="${vendor.email}"/></td>
                                <td><c:out value="${vendor.companyName}"/></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="3">No vendors are currently pending approval.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>

        <hr>

        <h2>Rejected Approvals</h2>
        <table border="1" cellpadding="5" style="width: 100%; border-collapse: collapse;">
            <thead>
                <tr>
                    <th>Vendor Name</th>
                    <th>Contact Email</th>
                    <th>Company Name</th>
                </tr>
            </thead>
            <tbody>
                <c:choose>
                    <c:when test="${not empty rejectedVendorList}">
                        <c:forEach var="vendor" items="${rejectedVendorList}">
                            <tr>
                                <td><c:out value="${vendor.name}"/></td>
                                <td><c:out value="${vendor.email}"/></td>
                                <td><c:out value="${vendor.companyName}"/></td>
                            </tr>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <tr>
                            <td colspan="3">No vendors have been rejected.</td>
                        </tr>
                    </c:otherwise>
                </c:choose>
            </tbody>
        </table>

        <hr>
        <a href="index.jsp">Logout</a>
    </div>
</body>
</html>
