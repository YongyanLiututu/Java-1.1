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
@WebServlet("/createOrderServlet")
public class CreateOrderServlet extends HttpServlet {
    OrderDao orderDao;

    public CreateOrderServlet() throws SQLException, ClassNotFoundException {
        this.orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("productId");
//        String productQuantity = req.getParameter("productQuantity");
        List<Product> productList= (List<Product>) req.getSession().getAttribute("productList");
        System.out.println(productList);
        double productprice = 0.0;
        int productquantity=0;
        boolean flag=false;
        for (Product product : productList) {
            if(product.getProductId().equals(productId)){
                 productprice = product.getProductPrice();
                productquantity = product.getProductquantity();
                flag=true;
            }
        }
        if(flag==false){
            req.setAttribute("ErrorMessage", "Product id does not exist, please check your product id");
            req.getRequestDispatcher("CreateOrder.jsp").forward(req, resp);
            return;
        }
        if(productquantity==0){
            req.setAttribute("ErrorMessage", "Product has been sold out, please selecr other product");
            req.getRequestDispatcher("CreateOrder.jsp").forward(req, resp);
            return;
        }
        Integer productQuantity1 = Integer.valueOf(req.getParameter("productQuantity"));
        Double totalPrice = productprice*productQuantity1;
//        System.out.println(totalPrice);


        try {
            Order order = new Order();
            order.setId(UUID.randomUUID().toString());
            order.setUserId((String) req.getSession().getAttribute("userId"));
            if((String) req.getSession().getAttribute("userId") == null){
                order.setUserId("anonymous user "+ UUID.randomUUID().toString().substring(6));
            }
            req.getSession().setAttribute("userId",order.getUserId());
            order.setProductId(productId);
            order.setProductPrice(productprice);
            order.setProductQuantity(productQuantity1);
            order.setTotalPrice(totalPrice);
//            order.setOrderTime(new Timestamp(System.currentTimeMillis()));
            Date day=new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(df.format(day));
//            df.format(day)
            System.out.println("123");
            order.setOrderTime(df.format(day));
            order.setOrderStatus("active");

            orderDao.createOrder(order);

            System.out.println("122");
            ArrayList<Object> orderList = new ArrayList<>();

       System.out.println(req.getSession().getAttribute("orderList"));

            if(req.getSession().getAttribute("orderList")!=null){
                orderList = (ArrayList<Object>) req.getSession().getAttribute("orderList");

            }
            orderList.add(order);
            System.out.println(order);
            req.getSession().setAttribute("orderList", orderList);
            resp.sendRedirect("MyOrder.jsp");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
            resp.sendRedirect("Interface.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
