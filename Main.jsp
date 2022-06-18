<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        body {
            position: relative;
        }
        #first, #second, #third, #fourth {
            height: 100vh;
        }
        #first {
            background: linear-gradient(270deg, rgba(255, 0, 0, 0.5), rgba(200, 150, 0, 0.2));
            display: flex;
            flex-direction: column;
        }
        #second {
            background: linear-gradient(90deg, rgba(66, 134, 244, 0.5), rgba(96, 115, 255, 0.8));
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            padding: 20px;
        }
        #third {
            background: linear-gradient(270deg, rgba(255, 0, 0, 0.5), rgba(200, 150, 0, 0.2));
        }
        #fourth {
            background: linear-gradient(90deg, rgba(66, 134, 244, 0.5), rgba(96, 115, 255, 0.8));
        }
        .nav-ul {
            position: fixed;
            height: 10vh;
            bottom: 0;
            left: 0px;
            right: 0px;
            display: flex;
            flex-direction: row;
            list-style: none;
            background: transparent;
            justify-content: center;
            align-items: center;
        }
        .nav-li {
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 5px;
            width: 40px;
            height: 40px;
            font: bold 12px/30px Georgia, serif;
            color: #fff;
            border-radius: 50%;
            background: #4b0082;
        }
        .top {
            border-radius: 0;
            width: 75px;
            border-radius: 8%;
            box-shadow: 4px 4px 0 0 #230f3f;
        }
        @media (max-width: 360px) {
            .bottom {
                margin: 5px;
                width: 40px;
                height: 40px;
                font-size: 12px;
            }
        }
        a:hover {
            text-decoration: none;
            cursor: pointer;
        }
        .nav_top {
            display: flex;
            flex-direction: row-reverse;
        }
        .header_top {
            display: flex;
            align-items: center;
        }
        #brand {
            display: flex;
            flex-direction: column;
            font: italic bold 30px/30px Georgia, serif;
            color: #fff;
            padding: 10px;
            align-items: center;
        }
        #tagline {
            font: italic bold 12px/30px Georgia, serif;
            color: #fff;
        }
        #screen {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            position: relative;
            top: -50px;
        }
        a.TUTU{
            text-align: center;
            padding: 10px;
            width: 70%;
            margin-top: 10px;
            background-image: linear-gradient(to right,#a6c1ee,#fbc2eb);
            color: #FFFFFF;
            font-size: 20px;
        }

    </style>
</head>
<body>
<div id="first">
    <div id="screen">
        <div id="brand">
            <h1> Hello!<%= session.getAttribute("lastName")%> </h1>
            <a style="padding-top:20px; color: white" href="managment.jsp">Manage my account</a>
            <a  class="TUTU" href="MyPayment.jsp">My Payment</a>
            <a  class="TUTU" href="MyOrder.jsp">My Order</a>
            <a  class="TUTU" href="AllProduct.jsp">All Product page</a>
            <a  class="TUTU" href="findAllSupplierServlet">All Supplier page</a>
            <a  class="TUTU" href="ManageProduct.jsp">Manage Product (Staff only)</a>

            <form action="readLogServlet" method="post">
                <input type="submit" name="readLog" value="Check my log">
            </form>
            <form action="logoutServlet" method="post">
                <input type="submit" name="logout" value="Logout">
            </form>
        </div>
    </div>
</div>
</body>
</html>