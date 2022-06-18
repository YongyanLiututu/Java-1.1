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

@WebServlet("/getOrderByOrderIdServlet")
public class GetOrderByOrderIdServlet extends HttpServlet {
    OrderDao orderDao;

    public GetOrderByOrderIdServlet() throws SQLException, ClassNotFoundException {
        this.orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        try {
            SETREQUSET(req, resp, orderId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("Interface.jsp");
        }
    }

    private void SETREQUSET(HttpServletRequest req, HttpServletResponse resp, String orderId) throws SQLException, IOException {
        Order order = orderDao.getOrderByOrderId(orderId);
        req.getSession().setAttribute("orderById", order);
        resp.sendRedirect("GetOrderByOrderId.jsp");
    }
}
