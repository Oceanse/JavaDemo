package com.demo.JDBC.mysql.demo2;


import java.sql.*;


/**
 * 1 加载驱动程序：
 *   Class.forName(driverClass)//加载MySql驱动
 *
 * 2 获得数据库连接：
 *   DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DBname", "root", "root");
 *
 * 3 创建Statement对象执行sql语句：
 *  Statement statement = conn.createStatement();
 *  statement.executeQuery(selectsql);
 *  statement.executeUpdate(insertsql)
 *  statement.executeUpdate(deletesql)
 *  statement.executeUpdate(updatesql)
 *
 */
public class StatementDemo {

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


        //插入数据1
        String name="aaa";
        String password="111";
        String insertSql = "INSERT INTO stu VALUES (" + "\""+ name+"\""+","+"\""+password+"\""+")";//INSERT INTO stu VALUES ("aaa","111")
        int i3 = statement.executeUpdate(insertSql);
        if (i3==1) {
            System.out.println("insert fully");
        } else {
            System.out.println("failed to insert");
        }



        //插入数据2
        String name2="bbb";
        String password2="222";
        String insertSql2 = "INSERT INTO stu VALUES (" + "\""+ name2+"\""+","+"\""+password2+"\""+")";//INSERT INTO stu VALUES ("bbb","222")
        int i4 = statement.executeUpdate(insertSql2);
        if (i4==1) {
            System.out.println("insert fully");
        } else {
            System.out.println("failed to insert");
        }


        //查询所有
        String querySql = "select * from stu";
        ResultSet resultSet = statement.executeQuery(querySql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name")+":"+resultSet.getString("password"));
        }


        //更新数据
        String name3="aaa";
        String password3="333";
        String updateSql = "update stu set password=" + "\"" + password3 + "\"" + "where name = " + "\"" + name3+"\"";//update stu set password="333"where name = "aaa"
        int i5 = statement.executeUpdate(updateSql);
        if (i5==1) {
            System.out.println("update fully");
        } else {
            System.out.println("failed to update");
        }



        //查询
        String name4="aaa";
        String querySql2 = "select * from stu where name = "+"\""+name4+"\"";//select * from stu where name = "aaa"
        ResultSet resultSet2 = statement.executeQuery(querySql2);
        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("name")+":"+resultSet2.getString("password"));
        }

        statement.close();
    }
}
