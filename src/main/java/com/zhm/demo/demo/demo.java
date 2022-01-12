package com.zhm.demo.demo;

import java.sql.*;

public class demo {

    /**
     * 数据库地址 替换成本地的地址
     */
    private static final String url = "jdbc:mysql://120.26.194.177:3306/zhuhamei?serverTimezone=GMT%2B8&characterEncoding=utf8&useSSL=false&useUnicode=true";
    /**
     * 数据库用户名
     */
    private static final String username = "root";
    /**
     * 密码
     */
    private static final String password = "107912@zhmCG";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
          // 加载驱动
          Class.forName("com.mysql.cj.jdbc.Driver");
          // 创造连接
        Connection connection = DriverManager.getConnection(url, username, password);
        // 创建可以执行sql对象
        Statement statement = connection.createStatement();
        String sql="select * from user_t where id = 1";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String id = resultSet.getString("id");
            String name = resultSet.getString("user_name");
            String age = resultSet.getString("age");
            System.out.println("id="+id+",name="+name+",age="+age);
        }
        // 6. 关闭连接
        resultSet.close();
        connection.close();
    }
}
