<!DOCTYPE html>
<html>
<head>
    <title>Index Page</title>
</head>
<body>
    <h2>Hello Admin</h2>

    <form action="<%= request.getContextPath() %>/admin/requestVendor" method="get">
            <button type="submit">Invite Vendor</button>
        </form>

        <form action="<%= request.getContextPath() %>/admin/vendors" method="get">
            <button type="submit">View Vendors</button>
        </form>

        <form action="<%= request.getContextPath() %>/admin/display" method="get">
            <button type="submit">View Users</button>
        </form>
</body>
</html>
