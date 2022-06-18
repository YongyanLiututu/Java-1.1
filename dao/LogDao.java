/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.dao;

import com.mycompany.iotbay1.models.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class LogDao {
    private Connection conn;
    
    public LogDao() throws ClassNotFoundException , SQLException{
        DBConnector c = new DBConnector();
        conn = c.getConnection();
    }
    
    //Search for log records based on the user ID
    public List<Log> findLog(String userId) throws SQLException{
        List<Log> loglist = new ArrayList<>();    
        PreparedStatement p = conn.prepareStatement("select * from log where user_id=?");
        p.setString(1, userId);
        ResultSet result = p.executeQuery();
        while (result.next()){
            Log log = new Log();
            log.setId(result.getString("log_id"));
            log.setUserid(result.getString("user_id"));
            log.setLoginTime(result.getTimestamp("login_time"));
            log.setLogoutTime(result.getTimestamp("logout_time"));
            loglist.add(log);
        }
        return loglist;
    }
    
    //Login record
    public String addLoginLog(String userId)throws SQLException{
        PreparedStatement p = conn.prepareStatement("insert into log(log_id,user_id, login_time) values(?,?,?)");
        String uuid = UUID.randomUUID().toString();
        p.setString(1, uuid);
        p.setString(2, userId);
        p.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
        p.executeUpdate();
        return uuid;
    }
    
    //Logout record
    public void addLogoutLog(String sessionUUID) throws SQLException{
        PreparedStatement p = conn.prepareStatement("update log set logout_time=? where log_id=?");
        p.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
        p.setString(2, sessionUUID);
        p.executeUpdate();
    }
}
