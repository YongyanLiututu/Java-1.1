<%--
  Created by IntelliJ IDEA.
  User: Michael
  Date: 2022/4/28
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Order</title>
    <style>
        body {
            margin: 0;
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
            font-size: 10px;
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
            font-size: 10px;
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
            width: 10%;
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
            font-size: 15px;
        }
        .De table{
            margin-left:440px;
            align:center;
            text-align:center;
            width: 30%;
            margin-bottom: 10px;
            background: rgba(0,0,0,0.3);
            border: none;
            outline: none;
            padding: 10px;
            font-size: 10px;
            color: #fff;
            text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
            border: 1px solid rgba(0,0,0,0.3);
            border-radius: 4px;
            box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
            -webkit-transition: box-shadow .5s ease;
            -moz-transition: box-shadow .5s ease;
            -o-transition: box-shadow .5s ease;
            -ms-transition: box-shadow .5s ease;
            transition: box-shadow .5s ease;}

        input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }
        a.TUTU{
            text-align: center;
            padding: 10px;
            width: 10%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 15px;
        }
        table, th, td {
            border:1px solid black;
        }
    </style>
</head>
<body>
<a  class="TUTU" href="MyOrder.jsp">Back to myOrder</a>
<div class="De">

<form method="post" action="updateOrderServlet">
    <h1>Write down the order you want to update!</h1>
    <table>
    <tr><label>
       <th> <input  class="Gt" type="text" name="orderId" required placeholder="Order Id"></th>
    </label>
    </tr>
        <tr>
    <label>
        <th><input class="Gt" type="text" name="productId" required placeholder="Product Id"></th>
    </label>
        </tr>
        <tr>
    <label>
        <th><input class="Gt" type="text" name="productQuantity" required placeholder="Product Quantity"></th>
    </label>
        </tr>
    </table>
    <% if((String)request.getAttribute("ErrorMessage") != null){
        String errorMessage = (String)request.getAttribute("ErrorMessage");
    %>
    <div style="color: red"><%= errorMessage %></div>
    <%
        }
    %>
    <input class="Nihao"  type="submit" value="Update">
</form>
</body>
</html>
