package day18jdbc;

import java.sql.*;

/**
 * @Author cxc
 * @Date 2021/1/18 21:01
 * @Version 1.0
 * @Email cxc_work@163.com
 * 查询
 */
public class JDBCDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "db1", "123456");
            //获取执行对象
            String sql = "select * from account";
            statement = conn.createStatement();
            //执行sql
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int moeny = resultSet.getInt("moeny");
                System.out.println(name + ":" + moeny);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement!=null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn!=null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
