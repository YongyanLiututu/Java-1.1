package com.mycompany.iotbay1.dao;
import  com.mycompany.iotbay1.models.Product;
import org.apache.derby.client.am.SqlException;
import org.apache.derby.client.am.SqlException;

import  java.sql.Connection;
import  java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.UUID;

public class ProductDao {
    private Connection conn;

    public ProductDao() throws SqlException, ClassNotFoundException, SQLException {
        DBConnector c=new DBConnector();
        conn =c.getConnection();
    }
    public List<Product> findAllProduct() throws SQLException{
        List<Product> productList=new ArrayList<>();
        PreparedStatement p=conn.prepareStatement("select * from product ");
        ResultSet result=p.executeQuery();
        while (result.next()){
            Product product=new Product();
            product.setProductId(result.getString("product_id"));
            product.setProductName(result.getString("product_name"));
            product.setProducttype(result.getString("product_type"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductquantity(result.getInt("product_quantity"));
            productList.add(product);
        }
        return  productList;
    }
    public  List<Product> findProductByName(String productName) throws SQLException{
        List<Product> productList= new ArrayList<>();
        PreparedStatement p=conn.prepareStatement("select * from  product where product_name like  ?");
        p.setString(1,"%"+productName+"%");
        ResultSet result=p.executeQuery();
        while (result.next()){
            Product product=new Product();
            product.setProductId(result.getString("product_id"));
            product.setProductName(result.getString("product_name"));
            product.setProducttype(result.getString("product_type"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductquantity(result.getInt("product_quantity"));

            productList.add(product);
        }
        return productList;
    }

    public  List<Product> findProductByType(String productType) throws SQLException{
        List<Product> productList= new ArrayList<>();
        PreparedStatement p=conn.prepareStatement("select *  from  product where product_type like ?");
        p.setString(1,"%"+productType+"%");
        ResultSet result=p.executeQuery();
        while (result.next()){
            Product product=new Product();
            product.setProductId(result.getString("product_id"));
            product.setProductName(result.getString("product_name"));
            product.setProducttype(result.getString("product_type"));
            product.setProductPrice(result.getDouble("product_price"));
            product.setProductquantity(result.getInt("product_quantity"));

            productList.add(product);
        }
        return productList;
    }

    public void addProduct(Product product) throws SQLException{
        PreparedStatement p=conn.prepareStatement("insert into product (product_id,product_name,product_type,product_price,product_quantity) value (?,?,?,?,?)");
        p.setString(1, UUID.randomUUID().toString());
        p.setString(2,product.getProductName());
        p.setString(3,product.getProducttype());
        p.setDouble(4,product.getProductPrice());
        p.setInt(5,product.getProductquantity());
        p.executeUpdate();

    }
    public void deleteProduct(String productId) throws SQLException{
        PreparedStatement p=conn.prepareStatement("delete from product where product_id=?");
        p.setString(1,productId);
//        p.executeUpdate();

        int i = p.executeUpdate();
        System.out.println(i);

    }

    public void updateProduct(Product product) throws SQLException {
        PreparedStatement p=conn.prepareStatement("update product set product_name=?,product_type=?,product_price=?,product_quantity=? where product_id=?");

//        p.setString(1, UUID.randomUUID().toString());
        p.setString(1,product.getProductName());
        p.setString(2,product.getProducttype());
        p.setDouble(3,product.getProductPrice());
        p.setInt(4,product.getProductquantity());
        p.setString(5,product.getProductId());
        p.executeUpdate();
    }
}
