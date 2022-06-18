<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2022/4/7
  Time: 14:08
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.List"%>
<%@page import="com.mycompany.iotbay1.models.User"%>
<%@page import="com.mycompany.iotbay1.models.Log"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Log</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Open+Sans);
        table {
            border: 1px solid #ccc;
            border-collapse: collapse;
            margin: 0;
            padding: 0;
            width: 100%;
            table-layout: fixed;
        }

        table caption {
            font-size: 1.5em;
            margin: .5em 0 .75em;
        }

        table tr {
            background-color: #f8f8f8;
            border: 1px solid #ddd;
            padding: .35em;
        }

        table th,
        table td {
            padding: .625em;
            text-align: center;
        }

        table th {
            font-size: .85em;
            letter-spacing: .1em;
            text-transform: uppercase;
        }

        @media screen and (max-width: 600px) {
            table {
                border: 0;
            }

            table caption {
                font-size: 1.3em;
            }

            table thead {
                border: none;
                clip: rect(0 0 0 0);
                height: 1px;
                margin: -1px;
                overflow: hidden;
                padding: 0;
                position: absolute;
                width: 1px;
            }

            table tr {
                border-bottom: 3px solid #ddd;
                display: block;
                margin-bottom: .625em;
            }

            table td {
                border-bottom: 1px solid #ddd;
                display: block;
                font-size: .8em;
                text-align: right;
            }

            table td::before {
                /*
                * aria-label has no advantage, it won't be read inside a table
                content: attr(aria-label);
                */
                content: attr(data-label);
                float: left;
                font-weight: bold;
                text-transform: uppercase;
            }

            table td:last-child {
                border-bottom: 0;
            }
        }
        /* general styling */
        body {
            font-family: "Open Sans", sans-serif;
            line-height: 1.25;
        }
    </style>
</head>
<body>
<%
    User user = (User) session.getAttribute("loginUser");
    if (user != null) {
%>
<div>
    <table>
        <caption>My Log</caption>
        <thead>
        <tr>
            <th>Email Address</th>
            <th>Login Time</th>
            <th>Logout Time</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Log> logList = (List<Log>) session.getAttribute("logList");
            for(Log log : logList){
        %>
        <tr>
            <td><%= user.getEmail()%></td>
            <td><%= log.getLoginTime() %></td>
            <td><%= log.getLogoutTime() %></td>
        </tr>
        <%}%>
        </tbody>
    </table>
        <a style="color: black" href="Main.jsp">Back to main</a>
</div>
<%
    } else {
        response.sendRedirect("Interface.jsp");
    }
%>

</body>
</html>
