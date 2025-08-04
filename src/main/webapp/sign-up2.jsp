<%=
    Integer id=(Integer) request.getParameter("id");
    String role=request.getParameter("role";)
%>
<script>
    const userExtra = document.getElementById("userExtra");

    roleSelect.addEventListener("change", () => {
        if (role=== "user") {
            userExtra.style.display = "block";
        } else {
            userExtra.style.display = "none";
        }
    });

    // Initial check
    roleSelect.dispatchEvent(new Event('change'));
</script>
<form action="<%= request.getContextPath() %>/signup2" method="post">
    <label for="name">Name: </label>
    <input type="text" name="name" required />
    <br><br>
    <label for="phone_num">Phone Number: </label>
    <input type="text" name="phone_num" required />
    <br><br>

    <%-- Show extra field only for users (optional with JS) --%>
    <div id="userExtra">
        <label for="report-to">Employee ID of Reporting Admin: </label>
        <input type="number" name="report-to" required />
        <br><br>
    </div>
    <input type="hidden" name="id" value="<%= id %>">
    <input type="hidden" name="role" value="<%= role %>">
    <button type="submit">Sign Up</button>
</form>