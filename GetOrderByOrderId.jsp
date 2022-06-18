<%@ page import="com.mycompany.iotbay1.models.Order" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            margin: 0;


            background-image: linear-gradient(125deg,#2c3e50,#27ae60,#2980b9,#e74c3c,#8e44ad);
            background-size: 400%;
            animation: bganimation 15s infinite;
        }
        .De {
            color: white;
            text-align: center;

            margin: 100px 0;
            font-size: 220x;
        }
        .De h1 { color: #fff; text-shadow: 0 0 10px rgba(0,0,0,0.3); letter-spacing:1px; text-align:center; }
        @keyframes bganimation {
            0%{
                background-position: 0% 50%;
            }
            50%{
                background-position: 100% 50%;
            }
            0%{
                background-position: 0% 50%;
            }

        }
        .De td {
            width: 50%;
            margin-bottom: 10px;
            background: rgba(0,0,0,0.3);
            border: none;
            outline: none;
            padding: 10px;
            font-size: 21px;
            color: #fff;
            text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
            border: 1px solid rgba(0,0,0,0.3);
            border-radius: 4px;
            box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
            -webkit-transition: box-shadow .5s ease;
            -moz-transition: box-shadow .5s ease;
            -o-transition: box-shadow .5s ease;
            -ms-transition: box-shadow .5s ease;
            transition: box-shadow .5s ease;
        }

        .De th {
            width: 50%;
            margin-bottom: 10px;
            background: rgba(0,0,0,0.3);
            border: none;
            outline: none;
            padding: 10px;
            font-size: 27px;
            color: #fff;
            text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
            border: 1px solid rgba(0,0,0,0.3);
            border-radius: 4px;
            box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
            -webkit-transition: box-shadow .5s ease;
            -moz-transition: box-shadow .5s ease;
            -o-transition: box-shadow .5s ease;
            -ms-transition: box-shadow .5s ease;
            transition: box-shadow .5s ease;
        }
        a.TUTU{
            text-align: center;
            padding: 10px;
            width: 10%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 15px;
        }
        input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }

        table, th, td {
            border:1px solid black;
        }
    </style>
    <title>GetOrderByOrderId</title>

</head>
<body>
<a  class="TUTU" href="MyOrder.jsp">Back to myOrder</a>
<div class="De">
<%
    Order order = (Order) session.getAttribute("orderById");

    if (order != null) {
%>
<table>
    <thead>
    <tr>
        <th>Order Id</th>
        <th>Product Id</th>
        <th>Product Price</th>
        <th>product Quantity</th>
        <th>Total Price</th>
        <th>order Time</th>
        <th>order Status</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><%= order.getId() %></td>
        <td><%= order.getProductId() %></td>
        <td><%= order.getProductPrice() %></td>
        <td><%= order.getProductQuantity() %></td>
        <td><%= order.getTotalPrice() %></td>
        <td><%= order.getOrderTime() %></td>
        <td><%= order.getOrderStatus() %></td>
    </tr>
    </tbody>
</table>
<%
    } else {
        response.sendRedirect("Interface.jsp");
    }
%>
</body>
</html>
