<!DOCTYPE html>
<html>
<head>
    <title>Request Vendor</title>
    <style>
        #snackbar {
            visibility: hidden;
            min-width: 250px;
            margin-left: -125px;
            background-color: #333;
            color: #fff;
            text-align: center;
            border-radius: 4px;
            padding: 14px;
            position: fixed;
            z-index: 1;
            left: 50%;
            bottom: 30px;
            font-size: 17px;
        }

        #snackbar.show {
            visibility: visible;
            animation: fadein 0.5s, fadeout 0.5s 2.5s;
        }

        @keyframes fadein {
            from { bottom: 0; opacity: 0; }
            to { bottom: 30px; opacity: 1; }
        }

        @keyframes fadeout {
            from { bottom: 30px; opacity: 1; }
            to { bottom: 0; opacity: 0; }
        }
    </style>
</head>
<body>
<h2>Request Vendor Access</h2>

<form action="${pageContext.request.contextPath}/admin/requestVendor" method="post">
    <label for="mail">Vendor Email:</label>
    <input type="email" id="mail" name="mail" required>
    <br><br>
    <button type="submit">Submit Request</button>
</form>

<form action="<%= request.getContextPath() %>/admin" method="get">
                    <button type="submit">Back to dashboard</button>
                </form>

<!-- Snackbar container -->
<div id="snackbar"></div>

<script>
    // Read the "status" parameter from the URL
    const urlParams = new URLSearchParams(window.location.search);
    const status = urlParams.get("status");

    if (status === "success") {
        showSnackbar("Request sent successfully!");
    } else if (status === "exists") {
        showSnackbar("Vendor already added!");
    }

    function showSnackbar(message) {
        const snackbar = document.getElementById("snackbar");
        snackbar.textContent = message;
        snackbar.className = "show";
        setTimeout(() => {
            snackbar.className = snackbar.className.replace("show", "");
        }, 3000);
    }
</script>
</body>
</html>
