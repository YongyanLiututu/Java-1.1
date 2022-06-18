/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.LogDao;
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
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet{
    UserDao userDao;
    LogDao logDao;
    
    public LoginServlet() throws SQLException,ClassNotFoundException {
        this.userDao = new UserDao();
        this.logDao = new LogDao();
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = null;
            try{
                user = userDao.findUser(email,password);
                request.getSession().setAttribute("loginUser", user);
                request.getSession().setAttribute("userId", user.getId());
                request.getSession().setAttribute("lastName", user.getLastName());
                String sessionUUID = logDao.addLoginLog(user.getId());
                request.getSession().setAttribute("uuid", sessionUUID);
                response.sendRedirect("Main.jsp");
            }catch (Exception e){
                e.printStackTrace();
                response.sendRedirect("Interface.jsp"); 
            }
    }
}
