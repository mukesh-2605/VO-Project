<form action="<%= request.getContextPath() %>/vendor/business-info" method="get">
    <p>Fill details and submit to be approved by admin, click below button to fill details</p>
    <button type="submit">Onboard Vendor</button>
</form>

<form action="<%= request.getContextPath() %>/admin/vendors" method="get">
    <button type="submit">View Vendor info</button>
</form>


<form action="<%= request.getContextPath() %>/login.jsp" method="get">
    <button type="submit">logout</button>
</form>