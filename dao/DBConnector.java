/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.iotbay1.dao;

import java.sql.*;

/**
 *
 * @author Administrator
 */
public class DBConnector {


    //    protected String URL = "jdbc:mysql://localhost:3306";
//    protected String db = "db6";
//    protected String dbuser = "root";
//    protected String dbpass = "123456";
//    protected String driver = "org.apache.derby.jdbc.ClientDriver";
//    protected Connection conn;
//
//    public DBConnector () throws ClassNotFoundException, SQLException{
//        Class.forName(driver);
//        conn = DriverManager.getConnection(URL + db, dbuser, dbpass);
//String url="jdbc:mysql://localhost:3306/db6?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
    String url="jdbc:mysql://localhost:3306/db6?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
    String user="root";
    String password="123456";
    public static Connection conn;

    public DBConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("连接成功");

    }
    public Connection getConnection() throws SQLException {
        return     DriverManager.getConnection(url,"root",password);

    }

    public void classConnection()throws SQLException{
        this.conn.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        //3.获取连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db6?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true","root","123456");

        //4.获取执行者对象
        Statement stat = con.createStatement();

        //5.执行sql语句，并且接收结果
        String sql = "SELECT * FROM users";
        ResultSet rs = stat.executeQuery(sql);
        System.out.println("123");
        //6.处理结果
        while(rs.next()) {
            System.out.println(rs.getString("user_id") + "\t" );
        }

        //7.释放资源
//        con.close();
//        stat.close();
//        con.close();
    }






}
