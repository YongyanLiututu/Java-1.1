package com.mycompany.iotbay1.dao;

import com.mycompany.iotbay1.models.Order;
import com.mycompany.iotbay1.models.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

public class OrderDao {
    private Connection conn;

    public OrderDao() throws ClassNotFoundException , SQLException {
        DBConnector c = new DBConnector();
        conn = c.getConnection();
    }

    public ArrayList<Object> getOrderByUserId(String userId) throws SQLException {
        ArrayList<Object> orderList = new ArrayList<>();
        PreparedStatement p =conn.prepareStatement("select * from orders where user_id = ?");
        p.setString(1, userId);
        ResultSet resultSet = p.executeQuery();
        while (resultSet.next()){
            Order order = new Order();
            order.setId(resultSet.getString("order_id"));
            order.setUserId(resultSet.getString("user_id"));
            order.setProductId(resultSet.getString("product_id"));
            order.setProductPrice(resultSet.getDouble("product_price"));
            order.setProductQuantity(resultSet.getInt("product_quantity"));
            order.setTotalPrice(resultSet.getDouble("total_price"));
            order.setOrderTime(resultSet.getString("order_time"));
            order.setOrderStatus(resultSet.getString("order_status"));
            orderList.add(order);

        }
        return orderList;

    }


    public void updateOrder (Order order) throws SQLException {
        deleteOrder(order.getId());
        PreparedStatement p =conn.prepareStatement("select * from product where product_id =?");
        p.setString(1, order.getProductId());
        ResultSet result = p.executeQuery();

        if(result.next()){
            Product product = new Product();
            product.setProductId(result.getString("product_id"));
            product.setProductName(result.getString("product_name"));
            product.setProducttype(result.getString("product_name"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductquantity(result.getInt("product_quantity"));
            if(product.getProductquantity() - order.getProductQuantity()>=0){
                PreparedStatement p1 = conn.prepareStatement("update orders set user_id=?,product_id=?,product_price=?,product_quantity=?,total_price=?,order_time=? where order_id=?");
                if(order.getUserId() == null){
                    order.setUserId("anonymous");
                }
                p1.setString(1, order.getUserId());
                p1.setString(2, order.getProductId());
                p1.setDouble(3, order.getProductPrice());
                p1.setInt(4, order.getProductQuantity());
                p1.setDouble(5, order.getTotalPrice());
                p1.setString(6, order.getOrderTime());
                p1.setString(7, order.getId());
                p1.executeUpdate();

                product.setProductquantity(product.getProductquantity()-order.getProductQuantity());
                PreparedStatement preparedStatement = conn.prepareStatement("update  product set  product_quantity = ? where  product_id = ?");
                preparedStatement.setInt(1, product.getProductquantity());
                preparedStatement.setString(2, product.getProductId());
                preparedStatement.executeUpdate();

            }

        }




    }
    public void deleteOrder (String orderId) throws SQLException {
        Order order = getOrderByOrderId(orderId);
        order.setOrderStatus("cancelled");
        PreparedStatement p = conn.prepareStatement("select  * from  product where  product_id = ?");
        p.setString(1, order.getProductId());

        ResultSet result = p.executeQuery();
//        System.out.println(result);
        if(result.next()){
            Product product = new Product();
            product.setProductId(result.getString("product_id"));
            product.setProductName(result.getString("product_name"));
            product.setProducttype(result.getString("product_name"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductquantity(result.getInt("product_quantity"));

            product.setProductquantity(product.getProductquantity()+order.getProductQuantity());

//            System.out.println(product.getProductquantity());

//            PreparedStatement p2 = conn.prepareStatement("delete from orders where order_id=?");
//            p2.setString(1, orderId);
//            p2.executeUpdate();

//            ,order_status= ?

            PreparedStatement p2 = conn.prepareStatement("update orders set order_status= ? where order_id=? ");
            p2.setString(1, order.getOrderStatus());
            p2.setString(2, orderId);
            p2.executeUpdate();


            PreparedStatement p3 = conn.prepareStatement("update product set product_quantity = ? where product_id=?");
            p3.setInt(1, product.getProductquantity());
            p3.setString(2, product.getProductId());

            p3.executeUpdate();
        }



    }


    public void createOrder (Order order) throws SQLException {
//
//        改
        PreparedStatement p1 = conn.prepareStatement("select * from product where product_id=?");
        p1.setString(1, order.getProductId());
        ResultSet result = p1.executeQuery();
        if(result.next()){
            Product product = new Product();
            product.setProductId(result.getString("product_id"));
            product.setProductName(result.getString("product_name"));
            product.setProducttype(result.getString("product_name"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductquantity(result.getInt("product_quantity"));
            System.out.println(product.getProductquantity());
            if(product.getProductquantity()-order.getProductQuantity()>= 0){
                PreparedStatement p = conn.prepareStatement("insert into orders (user_id, product_id, product_price, product_quantity, order_id, total_price,\n" +
                        "                    order_time,order_status) values (?,?,?,?,?,?,?,?)");
//                System.out.println(order.getUserId());
//                if(order.getUserId() == null){
//                    order.setUserId("anonymous user "+ UUID.randomUUID().toString().substring(6));
//                }
                p.setString(1, order.getUserId());
                p.setString(2, order.getProductId());
                p.setDouble(3, order.getProductPrice());
                p.setInt(4, order.getProductQuantity());
                p.setString(5, order.getId());
                p.setDouble(6, order.getTotalPrice());
                p.setString(7, order.getOrderTime());
                p.setString(8, order.getOrderStatus());

                p.executeUpdate();

                product.setProductquantity(product.getProductquantity()-order.getProductQuantity());
                PreparedStatement p3 = conn.prepareStatement("update product set  product_quantity= ? where product_id = ?");
                p3.setInt(1,product.getProductquantity());
                p3.setString(2, product.getProductId());
                p3.executeUpdate();

            }
        }


    }
    public Order getOrderByOrderId(String orderId) throws SQLException {
        Order order = new Order();
        PreparedStatement p =conn.prepareStatement("select * from orders where order_id like ?");
        p.setString(1, ""+orderId+"");
        ResultSet resultSet = p.executeQuery();
        while (resultSet.next()){
            order.setId(resultSet.getString("order_id"));
            order.setUserId(resultSet.getString("user_id"));
            order.setProductId(resultSet.getString("product_id"));
            order.setProductPrice(resultSet.getDouble("product_price"));
            order.setProductQuantity(resultSet.getInt("product_quantity"));
            order.setTotalPrice(resultSet.getDouble("total_price"));
            order.setOrderTime(resultSet.getString("order_time"));
            order.setOrderStatus(resultSet.getString("order_status"));
        }
        return order;
    }
    public ArrayList<Object> getOrderByOrderDate(String orderDate) throws SQLException {
        ArrayList<Object> orderList = new ArrayList<>();
        PreparedStatement p =conn.prepareStatement("select * from orders where order_time like ?");
        p.setString(1, orderDate+"%");
        ResultSet resultSet = p.executeQuery();

        while (resultSet.next()){
            Order order = new Order();
            order.setId(resultSet.getString("order_id"));
            order.setUserId(resultSet.getString("user_id"));
            order.setProductId(resultSet.getString("product_id"));
            order.setProductPrice(resultSet.getDouble("product_price"));
            order.setProductQuantity(resultSet.getInt("product_quantity"));
            order.setTotalPrice(resultSet.getDouble("total_price"));
            order.setOrderTime(resultSet.getString("order_time"));
            order.setOrderStatus(resultSet.getString("order_status"));
            orderList.add(order);

        }
        return orderList;



    }
}
