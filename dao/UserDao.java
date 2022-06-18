/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.dao;

import com.mycompany.iotbay1.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author Administrator
 */
public class UserDao {
    private Connection conn;
    
    public UserDao() throws ClassNotFoundException , SQLException{
        DBConnector c = new DBConnector();
        conn = c.getConnection();
    }
    //find 
   public User findUser(String email, String password) throws SQLException{
       PreparedStatement p = conn.prepareStatement("select * from users where email = ? and password = ?");
       p.setString(1, email);
       p.setString(2, password);
       ResultSet result = p.executeQuery();
       if(result .next()){
           User user = new User();
           user.setId(result.getString("user_id"));
           user.setFristName(result.getString("firstname"));
           user.setLastName(result.getString("lastname"));
           user.setEmail(result.getString("email"));
           user.setType(result.getString("type"));
           return user;
       }
       return null;
   }
   //add
    public void addUser(User user) throws SQLException{
        PreparedStatement p = conn. prepareStatement("insert into users(user_id,firstname, lastname,email, password, type) values(?,?,?,?,?,?)");
        p.setString(1, UUID.randomUUID().toString());
        p.setString(2, user.getFirstName());
        p.setString(3, user.getLastName());
        p.setString(4, user.getEmail());
        p.setString(5, user.getPassword());
        p.setString(6, user.getType());
        p.executeUpdate();
        
    }
    
    //delete
    public void deleteUser(String userId)throws SQLException{
        PreparedStatement p = conn.prepareStatement( "delete from users where user_id=?");
        p.setString(1, userId);
        p.executeUpdate();
    }
            
    //update
    public void updateUser(User user)throws SQLException{
        PreparedStatement p = conn.prepareStatement("update users set firstname=?, lastname=?, email=?, password=?, type=? where user_id=?");
        p.setString(1, user.getFirstName());
        p.setString(2, user.getLastName());
        p.setString(3,user.getEmail());
        p.setString(4,user.getPassword());
        p.setString(5,user.getType());
        p.setString(6,user.getId());
        p.executeUpdate();
    }
}
