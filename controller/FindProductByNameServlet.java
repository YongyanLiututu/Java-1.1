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

@WebServlet("/findProductByNameServlet")
public class FindProductByNameServlet extends HttpServlet {
    ProductDao productDao;
    public FindProductByNameServlet() throws SQLException,ClassNotFoundException, SqlException {
        this.productDao=new ProductDao();
    }
    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String productName=request.getParameter("productName");
        List<Product> productList=new ArrayList<>();

        try{
            productList=productDao.findProductByName(productName);
//            System.out.println(productList);
            request.getSession().setAttribute("productByName",productList);
            if(productList.isEmpty()){
                request.getSession().setAttribute("Error","No such product");
            }
            response.sendRedirect("FindProductByName.jsp");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(productList);
            response.sendRedirect("Interface.jsp");
        }
    }
}
