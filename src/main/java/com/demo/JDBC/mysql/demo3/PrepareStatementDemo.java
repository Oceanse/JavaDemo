package com.demo.JDBC.mysql.demo3;


import java.sql.*;


/**
 * PreparedStatement类：会对sql文进行预编译，预编译后，会存储在PreparedStatement对象中，等下次再执行这个PreparedStatement对象时，会提高很多效率
 * <p>
 * 构造方法： public PrepareStatement preparedStatement（String sql, eg:String sql = "INSERT INTO stu VALUES(?,?)";
 * <p>
 * 主要方法：
 * int executeUpdate() 可以执行DML：表的创建删除，成功返回0； 数据的增删改，成功返回受改动的记录的数量
 * ResultSet executeQuery() throws SQLException： 只能执行查询sql
 */
public class PrepareStatementDemo {

    public static final String driver = "com.mysql.cj.jdbc.Driver";//com.mysql.jdbc.Driver is depracted

    //这个是本地数据库中的一个database，名字叫User. localhost表示自己的电脑，3306是一个端口，表示访问的是数据库。后面?之后的就代表的是编号格式以及使用ssl协议
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
        PreparedStatement prepareStatement = connection.prepareStatement(dropTable);
        int i = prepareStatement.executeUpdate();//DDL执行成功返回0
        if (i == 0) {
            System.out.println("stu table is deleted successfully");
        } else {
            System.out.println("stu table is failed to delete");
        }

        //创建stu表
        String createStuTable = "CREATE TABLE stu(name varchar(50) not null primary key, password varchar(20) not null)";
        PreparedStatement prepareStatement2 = connection.prepareStatement(createStuTable);
        int i2 = prepareStatement2.executeUpdate();//DDL执行成功返回0
        if (i2 == 0) {
            System.out.println("stu table is created successfully");
        } else {
            System.out.println("stu table is failed to create");
        }


        //插入数据1
        String insertSql = "INSERT INTO stu VALUES(?,?)";
        PreparedStatement prepareStatement3 = connection.prepareStatement(insertSql);
        prepareStatement3.setString(1, "aaa");
        prepareStatement3.setString(2, "111");
        int i3 = prepareStatement3.executeUpdate();
        if (i3 == 1) {
            System.out.println("insert fully");
        } else {
            System.out.println("failed to insert");
        }

        //插入数据2
        prepareStatement3.setString(1, "bbb");
        prepareStatement3.setString(2, "222");
        int i4 = prepareStatement3.executeUpdate();
        if (i4 == 1) {
            System.out.println("insert fully");
        } else {
            System.out.println("failed to insert");
        }


        //查询所有
        String querySql = "select * from stu";
        PreparedStatement prepareStatement4 = connection.prepareStatement(querySql);
        ResultSet resultSet = prepareStatement4.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name") + ":" + resultSet.getString("password"));
        }


        //更新数据
        String updatesql = "update stu set password = ? where name=?";
        PreparedStatement prepareStatement5 = connection.prepareStatement(updatesql);
        prepareStatement5.setString(1,"333");
        prepareStatement5.setString(2,"aaa");
        int i5 = prepareStatement5.executeUpdate();
        if (i5 == 1) {
            System.out.println("update fully");
        } else {
            System.out.println("failed to update");
        }


        //查询
        String querySql2 = "select * from stu where name =?";
        PreparedStatement prepareStatement6 = connection.prepareStatement(querySql2);
        prepareStatement6.setString(1, "aaa");
        ResultSet resultSet2 = prepareStatement6.executeQuery();
        while (resultSet2.next()) {
            System.out.println(resultSet2.getString("name") + ":" + resultSet2.getString("password"));
        }

    }
}
