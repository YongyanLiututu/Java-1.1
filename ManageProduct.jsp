
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.iotbay1.models.User" %>
<%@ page import="com.mycompany.iotbay1.models.Product" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ManageProduct</title>
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
        a{
            color:#FFFFFF;
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
</head>
<body>
<a   class="TUTU" color="# ffffffff" style="color: red" href="Main.jsp">Main page!</a>
<div class="De">
        <%!private class script { }
%>
        <%
    User user = (User) session.getAttribute("loginUser");
    if (user != null && user.getType().equals("staff")) {
//        if (true) {
//if(productList.isEmpty()){


%>
<jsp:include page="/findAllProductServlet" />
<a href="AddProduct.jsp">Add product</a>
<a href="UpdateProduct.jsp" target="_blank">Update product</a>
<a href="DeleteProduct.jsp" target="_blank">Delete product</a>
<table>
    <thead>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>type</th>
        <th>price</th>
        <th>quantity</th>
    </tr>
    </thead>
    <tbody>
    <%

        List<Product> productList = (List<Product>) session.getAttribute("productList");
//        System.out.println(session);
        for(Product product : productList){
    %>
    <tr>
        <td><%= product.getProductId() %></td>
        <td><%= product.getProductName() %></td>
        <td><%= product.getProducttype() %></td>
        <td><%= product.getProductPrice() %></td>
        <td><%= product.getProductquantity() %></td>
    </tr>
    <%}%>
    </tbody>
</table>
<%
    } else {
        request.setAttribute("mess","You can not manage product, please login with staff account!");
request.getRequestDispatcher("Interface.jsp").forward(request,response);


    }
%>
<%--    <h1> Hello!<%= session.getAttribute("error")%> </h1>--%>
</body>
</html>
