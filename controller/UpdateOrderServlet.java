package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.OrderDao;
import com.mycompany.iotbay1.models.Order;
import com.mycompany.iotbay1.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@WebServlet("/updateOrderServlet")
public class UpdateOrderServlet extends HttpServlet {
    OrderDao orderDao;

    public UpdateOrderServlet() throws SQLException, ClassNotFoundException {
        this.orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId = req.getParameter("orderId");
        String productId = req.getParameter("productId");

        List<Product> productList= (List<Product>) req.getSession().getAttribute("productList");
        Double productPrice=0.0;
        for (Product product : productList) {
            if(product.getProductId().equals(productId)){
                productPrice=product.getProductPrice();

            }
        }

//        try {
//            if(orderDao.getOrderByOrderId(orderId)==null){
//                req.getRequestDispatcher("MyOrder.jsp").forward(req, resp);
//            }
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }


        if(productPrice==0.0){
            req.setAttribute("ErrorMessage", "Product id you enter does not exist, please check it");
            req.getRequestDispatcher("CreateOrder.jsp").forward(req, resp);
            return;
        }
        Integer productQuantity = Integer.valueOf(req.getParameter("productQuantity"));
        Double totalPrice = productPrice*productQuantity;
        try {
            Order order = new Order();
            order.setId(orderId);
            order.setUserId((String) req.getSession().getAttribute("userId"));
            order.setProductId(productId);
            order.setProductPrice(productPrice);
            order.setProductQuantity(productQuantity);
            order.setTotalPrice(totalPrice);
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            order.setOrderTime(df.format(day));
            order.setOrderStatus("active");
            List<Order> orderList =new ArrayList<>();
            if(req.getSession().getAttribute("orderList")!=null){
                orderList = (List<Order>) req.getSession().getAttribute("orderList");
            }
            boolean updateCompleted =false;
            for (Order order1 : orderList) {
                if(order1.getId().equals(orderId)){
                    orderList.remove(order1);
                    updateCompleted= true;
                    break;

                }
            }
            if(updateCompleted){
                orderDao.updateOrder(order);
            }else {
                req.setAttribute("Error Message", "Please enter the correct orderId");
                req.getRequestDispatcher("UpdateOrder.jsp").forward(req, resp);
                return;
            }
            orderList.add(order);
            req.getSession().setAttribute("orderList", orderList);
            resp.sendRedirect("MyOrder.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("Interface.jsp");
        }
    }
}
