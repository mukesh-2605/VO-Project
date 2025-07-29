<!DOCTYPE html>
<html>
<head>
    <title>Vendor Business Info</title>
</head>
<body>
<h2>Business Info</h2>
<form action="/VendorOnboard/vendor/submit-business-info" method="post">
    <label for="name">Primary Contact Person Name: </label>
    <input type="text" id="name" name="name" required>
    <br><br>
    <label for="company_name">Company Name:</label>
    <input type="text" id="company_name" name="company_name" required>
    <br><br>
    <label for="category">Category of Products:</label>
    <input type="text" id="category" name="category" required>
    <br><br>
    <label for="phone_num">Phone Number:</label>
    <input type="number" id="phone_num" name="phone_num" required>
    <br><br>
    <label for="website">website:</label>
    <input type="url" id="website" name="website" required>
    <br><br>
    <label for="payment_terms">Payment Terms:</label>
    <input type="text" id="payment_terms" name="payment_terms" required>
    <br><br>
    <button type="submit">Save and Next</button>
</form>
</body>
</html>
