package day18jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @Author cxc
 * @Date 2021/1/18 21:01
 * @Version 1.0
 * @Email cxc_work@163.com
 * 添加、修改、删除
 */
public class JDBCDemo01 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement statement = null;
        try {
            //加载MySql驱动
            Class.forName("com.mysql.jdbc.Driver");
            //获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "db1", "123456");
            //创建连接对象
            statement = conn.createStatement();
            //执行sql语句
//            String sql = "insert into account values(null,'wangwu','1500')";
//            String sql = "update  account set moeny = 5000 where id = 3";
            String sql = "delete from account where id = 3 ";
            int i = statement.executeUpdate(sql);
            System.out.println(i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

    }
}
