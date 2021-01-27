package day18c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;
import day18jdbc.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author cxc
 * @Date 2021/1/18 23:51
 * @Version 1.0
 * @Email cxc_work@163.com
 * c3p0
 */
public class C3p0Demo01 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //获取databases
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
        //获取连接对象
            conn = ds.getConnection();
            String sql = "select * from account";
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int money = resultSet.getInt("moeny");
                System.out.println(name + ":" + money);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.close(resultSet, statement, conn);
        }


    }
}
