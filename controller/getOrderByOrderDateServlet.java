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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/getOrderByOrderDateServlet")

public class getOrderByOrderDateServlet extends HttpServlet {
    OrderDao orderDao;

    public getOrderByOrderDateServlet() throws SQLException, ClassNotFoundException {
        this.orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

//    public static void main(String[] args) {
//
//        Date date1 = new Date();
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = sdf.format(date1);
//        System.out.println(str);
//
//    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderDate = req.getParameter("OrderDate");

//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String str = sdf.format(orderDate);
////        DateFormat format = new SimpleDateFormat("yyyy-MM-dd ");
//        Timestamp timestamp = Timestamp.valueOf(str);

//        Timestamp startTime = new Timestamp(format.parse(startDate).getTime());
//
//        try {
//            Timestamp time = new Timestamp(new SimpleDateFormat("yyyy-MM-dd ").parse(orderDate));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        try {
            ArrayList<Object> order = orderDao.getOrderByOrderDate(orderDate);
            System.out.println(order);
            req.getSession().setAttribute("orderByOrderDate", order);
            resp.sendRedirect("GetOrderByOrderDate.jsp");
        } catch (Exception e){
            e.printStackTrace();


            resp.sendRedirect("MyOrder.jsp");
        }
    }
}
