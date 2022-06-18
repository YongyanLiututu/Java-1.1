package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.ProductDao;
import com.mycompany.iotbay1.dao.UserDao;
import com.mycompany.iotbay1.models.Product;
import org.apache.derby.client.am.SqlException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@WebServlet("/updateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    ProductDao productDao;
    public UpdateProductServlet() throws SQLException,ClassNotFoundException, SqlException {
        this.productDao=new ProductDao();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("Id");
        String name = request.getParameter("Name");
        String type = request.getParameter("Type");
        Pattern pattern = Pattern.compile("-?[0-9]+\\,?[0-9]*");
        Matcher priceIsNumber = pattern.matcher(request.getParameter("Price"));
        Matcher quantityIsNumber = pattern.matcher(request.getParameter("Quantity"));
        if(!(priceIsNumber.matches() && quantityIsNumber.matches())){
            request.setAttribute("ErrorMessage", "Please enter only digits");
            request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
            return;
        }
        Double price = Double.valueOf(request.getParameter("Price"));
        Integer quantity = Integer.valueOf(request.getParameter("Quantity"));
        try {
            Product product = new Product();
            product.setProductId(id);
            product.setProductName(name);

            product.setProducttype(type);
            product.setProductPrice(price);
            product.setProductquantity(quantity);
            System.out.println(product);
            productDao.updateProduct(product);
            response.sendRedirect("ManageProduct.jsp");
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
