package day18jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author cxc
 * @Date 2021/1/18 21:01
 * @Version 1.0
 * @Email cxc_work@163.com
 * Ԥִ��sql
 */
public class JDBCDemo03 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //��������
            Class.forName("com.mysql.jdbc.Driver");
            //��ȡ���Ӷ���
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "db1", "123456");
            //��ȡִ�ж���
            String sql = "insert into account values(null,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "maliuzi2");
            statement.setInt(2, 2000);
            int i = statement.executeUpdate();
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
