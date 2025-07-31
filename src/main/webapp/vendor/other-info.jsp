<%@ page import="org.json.JSONObject" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="org.example.model.Vendor" %>
<%
    Vendor vendor = (Vendor) request.getAttribute("vendor");
%>
<%
    String other_details_Json = vendor.getOther_details();
    JSONObject json = new JSONObject(other_details_Json);
    Iterator<String> keys = json.keys();
%>
<h2>Extra Info</h2>
<form action="<%= request.getContextPath() %>/vendor/other-info" method="post">
<%
    while (keys.hasNext()) {
        String key = keys.next();
        String value = json.optString(key, "");
%>
        <label for="<%= key %>"><%= key %>:</label>
        <input type="text" name="<%= key %>" id="<%= key %>" value="<%= value %>" required/>
        <br/><br>
<%
    }
%>
    <button type="submit">Submit for Approval</button>

</form>
<br><br>
<form action="<%= request.getContextPath() %>/vendor/other-info" method="get">
     <button type="submit">Back</button>
</form>


