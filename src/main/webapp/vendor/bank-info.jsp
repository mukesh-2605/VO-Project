<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="org.example.model.Vendor" %>
<%
    Vendor vendor = (Vendor) request.getAttribute("vendor");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Vendor Banking Info</title>
</head>
<body>

    <h2>Banking Info</h2>
    <br><br>
    <form action="<%= request.getContextPath() %>/vendor/bank-info" method="post">
            <label for="beneficiary_name">Beneficiary Name :  </label>
            <input type="text" id="beneficiary_name" name="beneficiary_name" value="<%= vendor != null && vendor.getBeneficiary_name()!=null ? vendor.getBeneficiary_name() : "" %>" required>
            <br><br>
            <label for="bank_name">Bank Name : </label>
            <input type="text" id="bank_name" name="bank_name" value="<%= vendor != null && vendor.getBank_name()!=null ? vendor.getBank_name() : "" %>" required>
            <br><br>
            <label for="acc_num">Account Number :</label>
            <input type="text" id="acc_num" name="acc_num" value="<%= vendor != null && vendor.getAcc_num()!=null ? vendor.getAcc_num() : "" %>" required>
            <br><br>
            <label for="acc_type">Account Type :</label>
            <input type="text" id="acc_type" name="acc_type" value="<%= vendor != null && vendor.getAcc_type()!=null ? vendor.getAcc_type() : "" %>" required>
            <br><br>
            <label for="routing_number">Routing Number :</label>
            <input type="text" id="routing_number" name="routing_number" value="<%= vendor != null && vendor.getRouting_number()!=null ? vendor.getRouting_number() : "" %>" required>
            <br><br>
        <button type="submit">Save and Next</button>
    </form>
    <form action="<%= request.getContextPath() %>/vendor/tax-info" method="get">
            <button type="submit">Back</button>
    </form>

    </body>

</html>
