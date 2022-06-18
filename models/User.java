/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.models;

/**
 *
 * @author Administrator
 */
public class User {
    private String id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String userName;
    private String type;
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getFirstName(){
        return firstName;
    }
    public void setFristName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this. lastName = lastName;
    }
    
    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this. userName = userName;
    }
    
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
}
