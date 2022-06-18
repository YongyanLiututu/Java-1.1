<%@ page import="com.mycompany.iotbay.models.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Management</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("loginUser");
    String email = user.getEmail();
    String password = user.getPassword();
    String firstname = user.getFirstName();
    String lastname = user.getLastName();
%>

<form method="post" action="updateUserServlet">
    <label>
        Email:<br>
        <input type="text" name="email" required value=<%=email %>>
        <br>
    </label>
    <label>
        Password:<br>
        <input type="password" name="password" required value=<%=password %>>
        <br>
    </label>
    <label>
        First name:<br>
        <input type="text" name="firstname" required value=<%=firstname %>>
        <br>
    </label>
    <label>
        Last name:<br>
        <input type="text" name="lastname" required value=<%=lastname %>>
        <br>
    </label>
    <input type="submit" value="Update">
</form>

<form method="post" action="deleteUserServlet">
    <input type="submit" value="Delete">
</form>
</body>
</html>
