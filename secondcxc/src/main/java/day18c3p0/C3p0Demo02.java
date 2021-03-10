package day18c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;
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
 * c3p0  参数验证
 */
public class C3p0Demo02 {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        //获取连接对象
        ComboPooledDataSource ds = new ComboPooledDataSource();
        for (int i = 1; i <= 11; i++) {
            conn = ds.getConnection();
            System.out.println(i+":"+conn);

            if(i==5){
                conn.close();
            }
        }


    }
}
