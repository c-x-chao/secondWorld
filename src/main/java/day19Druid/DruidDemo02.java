package day19Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import utils.JDBCUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author cxc
 * @Date 2021/1/19 21:27
 * @Version 1.0
 * @Email cxc_work@163.com
 * Druid 数据库连接池测试
 * 工具类
 */
public class DruidDemo02 {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "insert into account values(null,?,?)";
            statement = conn.prepareStatement(sql);
            statement.setString(1, "六六");
            statement.setInt(2, 56465);
            int i = statement.executeUpdate();
            System.out.println(i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCUtils.close(statement, conn);

        }
    }
}
