package day18c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author cxc
 * @Date 2021/1/18 23:51
 * @Version 1.0
 * @Email cxc_work@163.com
 * c3p0  参数验证
 */
public class C3p0Demo03 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //获取连接对象 获取指定c3p0 配置数据库name
        ComboPooledDataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 1; i <= 9; i++) {
            conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
