
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.iotbay1.models.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>AllProduct</title>
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
            /*text-transform: uppercase;*/
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
        input.Nihao{
            text-align: center;
            padding: 10px;
            width: 10%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 15px;
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
        input.Gt{
            text-align: center;
            padding: 10px;
            width: 40%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 25px;
        }
        input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }
         a{
             color: #FFFFFF;
         }
        table, th, td {
            border:1px solid black;
        }
    </style>
    <a color="# ffffffff" style="color: red" href="Main.jsp" >Main page!</a>
</head>
<body>
<jsp:include page="/findAllProductServlet" />


<div class="De">
    <form method="post" action="findProductByNameServlet">
        <label>
            <input CLASS="Gt" type="text" name="productName" required placeholder="Product Name">
        </label>
        <input class="Nihao" type="submit" value="Search By Name">

    </form>
    <form method="post" action="findProductByTypeServlet">
        <label>
            <input CLASS="Gt" type="text" name="productType" required placeholder="Product Type">
        </label>
        <input class="Nihao" type="submit" value="Search By Type">
    </form>

    <a href="CreateOrder.jsp" target="_blank">Order the product</a>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Type</th>
            <th>Price</th>
            <th>Quantity</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Product> productList = (List<Product>) session.getAttribute("productList");
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
        String mess = (String)request.getAttribute("mess");         // 获取错误属性
        if(mess != null) {
    %>
    <script type="text/javascript" language="javascript">
        alert("<%=mess%>");                                            // 弹出错误信息

    </script>
    <%
        }
    %>

</div>
</body>
</html>

