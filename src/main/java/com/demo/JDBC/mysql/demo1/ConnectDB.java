package com.demo.JDBC.mysql.demo1;


import java.sql.*;


/**
 *  DB_URL包含已有数据库的名字，直接进行连接
 *  String DB_URL = "jdbc:mysql://192.168.56.102:3306/user?useSSL=false";
 */
public class ConnectDB {

    public static final String driver = "com.mysql.cj.jdbc.Driver";//com.mysql.jdbc.Driver is depracted

    //user数据库要提前创建好， ?之后的就代表的是编号格式以及使用ssl协议
    public static final String url = "jdbc:mysql://192.168.56.102:3306/user?useSSL=false";

    public static final String username = "root";

    public static final String password = "123123";

    public static Connection con = null;




    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driver);//得到DriverManager，在下面建立连接时使用
        con = DriverManager.getConnection(url, username, password);//建立连接,使用的参数就是上面我们所定义的字符串常量。
        return con;
    }


    public static void main(String[] args) throws Exception {

        Connection connection = getConnection();

        //stu表存在则删除
        String dropTable = "drop table if exists stu";
        Statement statement = connection.createStatement();
        int i = statement.executeUpdate(dropTable);//DDL执行成功返回0
        if (i == 0) {
            System.out.println("stu table is deleted successfully");
        } else {
            System.out.println("stu table is failed to delete");
        }

        //创建stu表
        String createStuTable = "CREATE TABLE stu(name varchar(50) not null primary key, password varchar(20) not null)";
        int i2 = statement.executeUpdate(createStuTable);//DDL执行成功返回0
        if (i2 == 0) {
            System.out.println("stu table is created successfully");
        } else {
            System.out.println("stu table is failed to create");
        }


    }
}
