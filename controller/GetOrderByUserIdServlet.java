package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.OrderDao;
import com.mycompany.iotbay1.models.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

@WebServlet("/getOrderByUserIdServlet")
public class GetOrderByUserIdServlet extends HttpServlet {
    OrderDao orderDao;

    public GetOrderByUserIdServlet() throws SQLException, ClassNotFoundException {
        this.orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userid = req.getParameter("UserId");

        try {
            ArrayList<Object> order = orderDao.getOrderByUserId(userid);

            System.out.println(order);
            req.getSession().setAttribute("orderByid", order);
            resp.sendRedirect("getOrderByUserIdServlet.jsp");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("Interface.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
