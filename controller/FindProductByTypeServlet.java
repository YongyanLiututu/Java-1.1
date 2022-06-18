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

@WebServlet("/findProductByTypeServlet")
public class FindProductByTypeServlet  extends HttpServlet {
    ProductDao productDao;
    public FindProductByTypeServlet() throws SQLException,ClassNotFoundException, SqlException {
        this.productDao=new ProductDao();
    }
    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String productType=request.getParameter("productType");
        List<Product> productList= new ArrayList<>();
        try{
            productList=productDao.findProductByType(productType);
            System.out.println(productList);
            request.getSession().setAttribute("productByType",productList);
            response.sendRedirect("FindProductByType.jsp");
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("Interface.jsp");
        }
    }




}
