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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/deleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    OrderDao orderDao;

    public DeleteOrderServlet() throws SQLException, ClassNotFoundException {
        this.orderDao = new OrderDao();
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("Id");
        try {
            ArrayList<Order> orderList = new ArrayList<>();
            if(req.getSession().getAttribute("orderList")!=null){
                orderList = (ArrayList<Order>) req.getSession().getAttribute("orderList");
            }
            boolean deleteCompleted =false;
            for (Order order : orderList) {
                if(order.getId().equals(id)) {
                    orderList.remove(order);
                    deleteCompleted = true;
                    break;
                }

            }
            if(deleteCompleted){
                orderDao.deleteOrder(id);
            }else {
                req.setAttribute("ErrorMessage", "Please enter the correct orderId");
                req.getRequestDispatcher("DeleteOrder.jsp").forward(req, resp);
                return;
            }
            req.getSession().setAttribute("orderList", orderList);
//            req.getRequestDispatcher("DeleteOrder.jsp").forward(req, resp);
            resp.sendRedirect("MyOrder.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Interface.jsp");
        }
    }

}
