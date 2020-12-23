package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JdbcDemo {

    // 不能直接写../../mysql.ini
    private static final String FILENAME = JdbcDemo.class.getResource("../../").getPath() + "mysql.ini";

    public static void main(String[] args) {
        // 加载属性文件
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(FILENAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 读数据文件
        String driverName = properties.getProperty("driver");
        String dbURL = properties.getProperty("url");
        String userName = properties.getProperty("username");
        String userPassword = properties.getProperty("password");
        // 创建执行语句集合
        String[] sqls = {
                "insert into stu_info values(null, 'BoBo', '2', '2019-12-10', 'bbboobo@qq.com', 'China')",
                "insert into stu_info values(null, 'Sofmm', '2', '2019-12-12', 'sssofmm@foxmail.com', 'China')",
                "insert into stu_info values(null, 'Style', '2', '2019-12-14', 'sstyle@gmail.com', 'China')"
        };
        // 查找数据库驱动
        try {
            Class.forName(driverName);
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        // 连接数据库并进行操作
        try (Connection dbConnection = DriverManager.getConnection(dbURL, userName, userPassword)){
            // 关闭自动提交，开启事务
            dbConnection.setAutoCommit(false);
            // 创建Statement对象
            try (Statement statement = dbConnection.createStatement()) {
                // 循环执行SQL语句update
                for (String sql : sqls) {
                    statement.executeUpdate(sql);
                }
            }
            // 提交事务
            dbConnection.commit();
        } catch(SQLException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕！");
    }

}
