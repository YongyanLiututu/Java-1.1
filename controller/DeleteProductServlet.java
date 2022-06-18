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


@WebServlet("/deleteProductServlet")
public class DeleteProductServlet  extends HttpServlet {
    ProductDao productDao;
    public DeleteProductServlet() throws SQLException,ClassNotFoundException, SqlException {
        this.productDao=new ProductDao();
    }

    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String id=request.getParameter("Id");

        try{
            productDao.deleteProduct(id);

            response.sendRedirect("ManageProduct.jsp");
        }catch (Exception e){
            response.sendRedirect("Interface.jsp");
        }
    }

}
