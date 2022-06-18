/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.controller;

import com.mycompany.iotbay1.dao.LogDao;
import com.mycompany.iotbay1.dao.UserDao;
import com.mycompany.iotbay1.models.Log;
import com.mycompany.iotbay1.models.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author Administrator
 */
@WebServlet("/readLogServlet")
public class ReadLogServlet extends HttpServlet{
    UserDao userDao;
    LogDao logDao;
    
    public ReadLogServlet()throws SQLException,ClassNotFoundException{
        this.userDao = new UserDao();
        this.logDao = new LogDao();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        User user = (User)request.getSession().getAttribute("loginUser");
        try{
            List<Log> loglist = logDao.findLog(user.getId());
            request.getSession().setAttribute("logList", loglist);
            response.sendRedirect("Log.jsp");
        }catch(Exception e){
            response.sendRedirect("Interface.jsp");
    }
}
}
