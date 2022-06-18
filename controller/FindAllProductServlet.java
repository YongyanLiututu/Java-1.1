package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.ProductDao;
import com.mycompany.iotbay1.models.Product;
import org.apache.derby.client.am.SqlException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/findAllProductServlet")
public class FindAllProductServlet extends HttpServlet {
    ProductDao productDao;
    
    public  FindAllProductServlet() throws SQLException, ClassNotFoundException, SqlException {
        this.productDao=new ProductDao();

    }
       @Override
       protected void  doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
        List<Product> productList=new ArrayList<>();
        try {
            productList=productDao.findAllProduct();
            request.getSession().setAttribute("productList",productList);
        }
        catch (Exception e){

                response.sendRedirect("Interface.jsp");

        }
    }
}
