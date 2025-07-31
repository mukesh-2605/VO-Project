<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Dashboard</title>
</head>
<body>

    <div>
        <h1>Welcome, <c:out value="${sessionScope.userName}" default="User"/>!</h1>
        <p>This is your personal dashboard.</p>
        <hr>

        <h3>Your Actions</h3>
        <p><a href="userProfile">View My Profile</a></p>
        <hr>

        <%-- ============== NEW VENDOR LIST SECTION ============== --%>
        <h2>Approved Vendors</h2>
        <p>A list of vendors who have completed the onboarding process.</p>

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
        <%-- ============ END OF NEW VENDOR LIST SECTION ============ --%>

        <h2>Pending Approvals</h2>
                <p>A list of vendors awaiting approval.</p>
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

                <%-- ======================= REJECTED VENDORS ======================= --%>
        <h2>Rejected Approvals</h2>
        <p>A list of vendors whose applications were rejected.</p>
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
        <a href="login.jsp">Logout</a>
    </div>

</body>
</html>