package com.mycompany.iotbay1.controller;


import com.mycompany.iotbay1.dao.ProductDao;
import com.mycompany.iotbay1.models.Product;
import org.apache.derby.client.am.SqlException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
    ProductDao productDao;
    public AddProductServlet() throws SQLException,ClassNotFoundException, SqlException {
        this.productDao=new ProductDao();
    }
    @Override
    protected void  doPost(HttpServletRequest request, HttpServletResponse response)throws IOException {
        String name=request.getParameter("Name");
        String type=request.getParameter("Type");
        Pattern pattern=Pattern.compile("-?[0-9]+\\.?[0-9]*");
        Matcher priceIsNum=pattern.matcher(request.getParameter("Price"));
        Matcher quantityIsNum=pattern.matcher(request.getParameter("Quantity"));
        if(!(priceIsNum.matches()&&quantityIsNum.matches())){
            request.setAttribute("ErrorMessage","Please enter only digits in Price and Quantity");
            try {
                request.getRequestDispatcher("AddProduct.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
            return;
        }
        Double price=Double.valueOf(request.getParameter("Price"));
        Integer quantity=Integer.valueOf(request.getParameter("Quantity"));
        try{
            Product product=new Product();
            product.setProductName(name);

            product.setProducttype(type);
            product.setProductPrice(price);
            product.setProductquantity(quantity);
            productDao.addProduct(product);
            response.sendRedirect("ManageProduct.jsp");

        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("Interface.jsp");
        }



    }

}
