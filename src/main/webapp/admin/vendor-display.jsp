<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, org.example.model.Vendor" %>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0
    response.setDateHeader("Expires", 0); // Proxies
%>

<html>
<head>
    <title>Vendor List</title>
</head>
<body>
<h2>Pending Vendors</h2>
<script>
window.addEventListener('pageshow', function (event) {
  if (event.persisted || performance.getEntriesByType("navigation")[0].type === "back_forward") {
    location.reload();
  }
});

</script>

<script>
    function goToDetails(vendorId, email) {
        const url = '<%= request.getContextPath() %>/viewVendorDetails?id=' + vendorId;
        window.location.href = url;
    }
</script>

<script>
  const ctx = '<%= request.getContextPath() %>';

  function rejectVendor(id) {
      const reason = prompt("Please enter the reason for rejection:");
      if (reason !== null) {
          const form = document.getElementById("actionForm");
          form.action = ctx + "/admin/status/rejectVendor";
          document.getElementById("vendorIdField").value = id;
          document.getElementById("remarkField").value = reason;
          form.submit();
      }
  }

  function requestVendorData(id) {
      const details = prompt("Enter what information you need from the vendor:");
      if (details !== null) {
          const form = document.getElementById("actionForm");
          form.action = ctx + "/admin/status/requestVendor";
          document.getElementById("vendorIdField").value = id;
          document.getElementById("remarkField").value = details;
          form.submit();
      }
  }

</script>


<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Company</th>
        <th>Delete vendor</th>
        <th>Approve</th>
        <th>Reject</th>
        <th>Request more data</th>
    </tr>
    <%
        List<Vendor> pendingVendors = (List<Vendor>) request.getAttribute("pendingVendors");
        for (Vendor v : pendingVendors) {
    %>
    <tr style="cursor: pointer;" onclick="goToDetails('<%= v.getId() %>', '<%= v.getMail() %>')">
        <td><%= v.getName() != null ? v.getName() : "-" %></td>
        <td><%= v.getMail() %></td>
        <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
        <td onclick="event.stopPropagation();">
            <form action="<%= request.getContextPath() %>/admin/status/deleteVendor" method="post">
                <input type="hidden" name="id" value="<%= v.getId() %>" />
                <button type="submit">Delete</button>
            </form>
        </td>
        <td onclick="event.stopPropagation();">
            <form action="<%= request.getContextPath() %>/admin/status/approveVendor" method="post">
                <input type="hidden" name="id" value="<%= v.getId() %>" />
                <button type="submit">Approve</button>
            </form>
        </td>
        <td>
                <!-- Reject button -->
                  <button type="button"
                          onclick="event.stopPropagation(); rejectVendor(<%= v.getId() %>)">
                    Reject
                  </button>
                <?td>
        <td>
        <!-- Request button -->
          <button type="button"
                  onclick="event.stopPropagation(); requestVendorData(<%= v.getId() %>)">
            Request
          </button>
        <?td>
    </tr>
    <%
        }
    %>
</table>

    <h2>Requested Vendors</h2>
    <script>
        function goToDetails(vendorId, email) {
            const url = '<%= request.getContextPath() %>/viewVendorDetails?id=' + vendorId + '&email=' + encodeURIComponent(email);
            window.location.href = url;
        }
    </script>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Company</th>
            <th>Delete vendor</th>
        </tr>

    <%
            List<Vendor> requestedVendors = (List<Vendor>) request.getAttribute("requestedVendors");
            for (Vendor v : requestedVendors) {
        %>
        <tr style="cursor: pointer;" onclick="goToDetails('<%= v.getId() %>', '<%= v.getMail() %>')">
                <td><%= v.getName() != null ? v.getName() : "-" %></td>
                <td><%= v.getMail() %></td>
                <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
                <td onclick="event.stopPropagation();">
                    <form action="<%= request.getContextPath() %>/admin/status/deleteVendor" method="post">
                        <input type="hidden" name="id" value="<%= v.getId() %>" />
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        <%
            }
        %>
    </table>

    <h2>Approved Vendors</h2>
    <script>
        function goToDetails(vendorId, email) {
            const url = '<%= request.getContextPath() %>/viewVendorDetails?id=' + vendorId + '&email=' + encodeURIComponent(email);
            window.location.href = url;
        }
    </script>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Company</th>
            <th>Delete vendor</th>
            <th>Reject</th>
            <th>Request more data</th>
        </tr>
        <%
            List<Vendor> approvedVendors = (List<Vendor>) request.getAttribute("approvedVendors");
            for (Vendor v : approvedVendors) {
        %>
        <tr style="cursor: pointer;" onclick="goToDetails('<%= v.getId() %>', '<%= v.getMail() %>')">
                <td><%= v.getName() != null ? v.getName() : "-" %></td>
                <td><%= v.getMail() %></td>
                <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
                <td onclick="event.stopPropagation();">
                    <form action="<%= request.getContextPath() %>/admin/status/deleteVendor" method="post">
                        <input type="hidden" name="id" value="<%= v.getId() %>" />
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td>
                        <!-- Reject button -->
                          <button type="button"
                                  onclick="event.stopPropagation(); rejectVendor(<%= v.getId() %>)">
                            Reject
                          </button>
                        <?td>
                <td>
                        <!-- Request button -->
                          <button type="button"
                                  onclick="event.stopPropagation(); requestVendorData(<%= v.getId() %>)">
                            Request
                          </button>
                        <?td>
            </tr>
        <%
            }
        %>
    </table>

    <h2>Review Vendors</h2>
    <script>
        function goToDetails(vendorId, email) {
            const url = '<%= request.getContextPath() %>/admin/viewVendorDetails?id=' + vendorId + '&email=' + encodeURIComponent(email);
            window.location.href = url;
        }
    </script>
    <table border="1">
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Company</th>
            <th>Delete vendor</th>
            <th>Approve</th>
            <th>Reject</th>
            <th>Request more data</th>
        </tr>
        <%
            List<Vendor> reviewVendors = (List<Vendor>) request.getAttribute("reviewVendors");
            for (Vendor v : reviewVendors) {
        %>
        <tr style="cursor: pointer;" onclick="goToDetails('<%= v.getId() %>', '<%= v.getMail() %>')">
                <td><%= v.getName() != null ? v.getName() : "-" %></td>
                <td><%= v.getMail() %></td>
                <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
                <td onclick="event.stopPropagation();">
                    <form action="<%= request.getContextPath() %>/admin/status/deleteVendor" method="post">
                        <input type="hidden" name="id" value="<%= v.getId() %>" />
                        <button type="submit">Delete</button>
                    </form>
                </td>
                <td onclick="event.stopPropagation();">
                    <form action="<%= request.getContextPath() %>/admin/status/approveVendor" method="post">
                        <input type="hidden" name="id" value="<%= v.getId() %>" />
                        <button type="submit">Approve</button>
                    </form>
                </td>
                <td>
                        <!-- Reject button -->
                          <button type="button"
                                  onclick="event.stopPropagation(); rejectVendor(<%= v.getId() %>)">
                            Reject
                          </button>
                        <?td>
                <td>
                        <!-- Request button -->
                          <button type="button"
                                  onclick="event.stopPropagation(); requestVendorData(<%= v.getId() %>)">
                            Request
                          </button>
                        <?td>
            </tr>
        <%
            }
        %>
    </table>

    <h2>Rejected Vendors</h2>
        <script>
            function goToDetails(vendorId, email) {
                const url = '<%= request.getContextPath() %>/admin/viewVendorDetails?id=' + vendorId + '&email=' + encodeURIComponent(email);
                window.location.href = url;
            }
        </script>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Company</th>
                <th>Delete vendor</th>
                <th>Approve</th>
                <th>Request more data</th>
            </tr>
            <%
                List<Vendor> rejectedVendors = (List<Vendor>) request.getAttribute("rejectedVendors");
                for (Vendor v : rejectedVendors) {
            %>
            <tr style="cursor: pointer;" onclick="goToDetails('<%= v.getId() %>', '<%= v.getMail() %>')">
                    <td><%= v.getName() != null ? v.getName() : "-" %></td>
                    <td><%= v.getMail() %></td>
                    <td><%= v.getCompany_name() != null ? v.getCompany_name() : "-" %></td>
                    <td onclick="event.stopPropagation();">
                        <form action="<%= request.getContextPath() %>/admin/status/deleteVendor" method="post">
                            <input type="hidden" name="id" value="<%= v.getId() %>" />
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                    <td onclick="event.stopPropagation();">
                        <form action="<%= request.getContextPath() %>/admin/status/approveVendor" method="post">
                            <input type="hidden" name="id" value="<%= v.getId() %>" />
                            <button type="submit">Approve</button>
                        </form>
                    </td>
                    <td>
                            <!-- Request button -->
                              <button type="button"
                                      onclick="event.stopPropagation(); requestVendorData(<%= v.getId() %>)">
                                Request
                              </button>
                            <?td>
                </tr>
            <%
                }
            %>
        </table>
        <form action="<%= request.getContextPath() %>/admin" method="get">
                    <button type="submit">Back to dashboard</button>
                </form>
<script>
  // Replace current history entry with the same URL to prevent caching on back
  if (performance.navigation.type === 2) {
    // This is a back/forward navigation
    location.reload(true);
  }

  // OR: Always replace state on first load
  history.replaceState(null, '', location.href);
</script>
<form id="actionForm" method="post">
  <input type="hidden" name="id" id="vendorIdField">
  <input type="hidden" name="remark" id="remarkField">
</form>

</body>
</html>
