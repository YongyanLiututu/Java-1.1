/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.UserDao;

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
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
    UserDao userDao;
    
    public DeleteUserServlet() throws SQLException,ClassNotFoundException{
        this.userDao = new UserDao();
    }
    
    @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
         try{
             String userId = (String)request.getSession().getAttribute("userId");
             userDao.deleteUser(userId);
             request.getSession().invalidate();
             response.sendRedirect("Interface.jsp");
         }catch(Exception e){
             response.sendRedirect("Interface.jsp");
         }
     }
}
