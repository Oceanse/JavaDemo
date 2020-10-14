package com.demo.JDBC.mysql.demo1;

import java.sql.*;


/**
 * 数据库连接地址可以不带数据库名字，在代码中创建数据库
 * String DB_URL = "jdbc:mysql://192.168.56.102:3306/?useSSL=false";
 */
public class CreateDB_Tables {
    // JDBC driver name and database URL
    static final String driver = "com.mysql.cj.jdbc.Driver";//com.mysql.jdbc.Driver is depracted
    static final String DB_URL = "jdbc:mysql://192.168.56.102:3306/?useSSL=false"; //可以不提供数据库名称

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "123123";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            //Register JDBC driver
            Class.forName(driver);

            //Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            //数据库存在则删除
            System.out.println("deleting database...");
            String dropDB = "drop database if exists user";
            stmt.executeUpdate(dropDB);//DDL执行成功返回0

            //创建数据库
            System.out.println("Creating database...");
            String sql = "CREATE DATABASE user";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");


            //使用数据库
            String useDB = "use user";
            stmt.executeUpdate(useDB);


            //创建stu表
            String createStuTable = "CREATE TABLE stu(name varchar(50) not null primary key, password varchar(20) not null)";
            int i2 = stmt.executeUpdate(createStuTable);//DDL执行成功返回0
            if (i2 == 0) {
                System.out.println("stu table is created successfully");
            } else {
                System.out.println("stu table is failed to create");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            try {
                if (conn != null) conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            System.out.println("Goodbye!");
        }
    }

}
