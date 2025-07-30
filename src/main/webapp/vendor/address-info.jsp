<!DOCTYPE html>
<html>
<head>
    <title>Vendor Address Info</title>
    <script>
        function addShippingAddress() {
            var div = document.getElementById("shippingAddress");
            div.style.display="block";

            var button = document.getElementById("addButton");
            button.style.display="none";
        }
    </script>
</head>
<body>
    <h2>Address Info</h2>
    <br><br>
    <div id="container">
        <h5> Billing Address </h5>
        <label for="b_country">Country :  </label>
        <input type="text" id="b_country" name="b_country" required>
        <br><br>
        <label for="b_address">Address : </label>
        <input type="text" id="b_address" name="b_address" required>
        <br><br>
        <label for="b_city">City :</label>
        <input type="text" id="b_city" name="b_city" required>
        <br><br>
        <label for="b_state">State :</label>
        <input type="text" id="b_state" name="b_state" required>
        <br><br>
        <label for="b_zipcode">Zipcode :</label>
        <input type="text" id="b_zipcode" name="b_zipcode" required>
        <br><br>


        <div id="shippingAddress" style="display:none;">
            <h5> Billing Address </h5>
            <label for="s_country">Country :  </label>
            <input type="text" id="s_country" name="s_country" required>
            <br><br>
            <label for="s_address">Address : </label>
            <input type="text" id="s_address" name="s_address" required>
            <br><br>
            <label for="s_city">City :</label>
            <input type="text" id="s_city" name="s_city" required>
            <br><br>
            <label for="s_state">State :</label>
            <input type="text" id="s_state" name="s_state" required>
            <br><br>
            <label for="s_zipcode">Zipcode :</label>
            <input type="text" id="s_zipcode" name="s_zipcode" required>
            <br><br>
        </div>

    </div>
    <button id="addButton" style="display:block;" type"button" onclick="addShippingAddress">Add Shipping Address</button>
    <br>
    <button type="submit">Save and Next</button>
</body>

</html>
