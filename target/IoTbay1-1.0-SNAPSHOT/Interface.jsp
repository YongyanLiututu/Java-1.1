<%-- 
    Document   : interface
    Created on : 2022-3-24, 18:10:44
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interface</title>
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
                border: 3px solid #fff;
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
            .textbox {
                color: white;
                background: transparent;
                border: 1px solid white;
            }

        </style>
    </head>
    <body>
        <div id="first">
            <div id="screen">
                <div id="brand">
                    <div>IoTBay</div>
                    <div id="tagline">You need it, you want it, you got it.</div>
                    <a href="Login.jsp"><li class="nav-li top">Login</li></a>
                    <a href="Register.jsp"><li class="nav-li top">Sign Up</li></a>
                </div>
            </div>
        </div>
    </body>

</html>
