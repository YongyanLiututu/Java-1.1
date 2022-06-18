/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.controller;


import com.mycompany.iotbay1.dao.UserDao;
import com.mycompany.iotbay1.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author Administrator
 */
@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet{
    UserDao userDao;
    
    public RegisterServlet() throws SQLException,ClassNotFoundException{
        this.userDao = new UserDao();
    }
    
    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastName");
        
        try{
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setFristName(firstname);
        user.setLastName(lastname);
        user.setType("customer");
        userDao.addUser(user);
        response.sendRedirect("Login.jsp");
        }catch(SQLException e){
            e.printStackTrace();
            response.sendRedirect("Interface.jsp");
        }
        
        
    }
}
