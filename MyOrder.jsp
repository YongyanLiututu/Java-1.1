
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.iotbay1.models.Order" %><%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2022/4/28
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My Order</title>
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
        input.Nihao{
            text-align: center;
            padding: 10px;
            width: 15%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 15px;
        }
        a{
            color: #FFFFFF;
        }
        input.Gt{
            text-align: center;
            padding: 10px;
            width: 40%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 25px;
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
</head>
<body>
<a  class="TUTU" href="Main.jsp">Back to main page</a>
<a  class="TUTU" href="AllProduct.jsp">Back to All Product page </a>
<%--<a color="# ffffffff" style="color: red" href="Main.jsp">Main page!</a>--%>
<div class="De">
<form method="post" action="getOrderByOrderIdServlet">
    <label>
        <input  class="Gt" type="text" name="orderId" required placeholder="Full Order Id(Preventing SQL Injection)">
    </label>
    <input class="Nihao" type="submit" value="Search By Id"><br>


</form>



<form method="post" action="getOrderByUserIdServlet">
    <label>
        <input  class="Gt"  font-size: 15px type="text" name="UserId" required placeholder="Full User Id(Preventing SQL Injection)">
    </label>
    <input class="Nihao" type="submit" value="Search By UserId"><br>
</form>



    <form method="post" action="getOrderByOrderDateServlet">
        <label>
            <input  class="Gt" type="text" name="OrderDate" required placeholder="Order time">
        </label>
        <input class="Nihao" type="submit" value="Search By Ordertime"><br>
    </form>

<a href="UpdateOrder.jsp" target="_blank">Update order</a>
<a href="DeleteOrder.jsp" target="_blank">Delete order</a>
        <%!private class script { }
%>
        <%
    List<Order> orderList = (List<Order>) session.getAttribute("orderList");
    if (!(orderList==null)) {

%>

<table>
    <thead>
    <tr>
        <th>Order Id</th>
        <th>User Id</th>
        <th>Product Id</th>
        <th>Product Price</th>
        <th>product Quantity</th>
        <th>Total Price</th>
        <th>order Time</th>
        <th>order status</th>
    </tr>
    </thead>
    <tbody>
    <%
        for(Order order : orderList){
    %>
    <tr>
        <td><%= order.getId() %></td>
        <td><%= order.getUserId() %></td>
        <td><%= order.getProductId() %></td>
        <td><%= order.getProductPrice() %></td>
        <td><%= order.getProductQuantity() %></td>
        <td><%= order.getTotalPrice() %></td>
        <td><%= order.getOrderTime() %></td>
        <td><%= order.getOrderStatus() %></td>
    </tr>
    <%}%>
    </tbody>
</table>
<%
    } else {

request.setAttribute("mess","No order currently, now direct you to All product page." +
 "now you can order product here!");
request.getRequestDispatcher("AllProduct.jsp").forward(request,response);
//        response.sendRedirect("AllProduct.jsp");

        }
%>

</body>
</html>
