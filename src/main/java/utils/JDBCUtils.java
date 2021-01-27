package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author cxc
 * @Date 2021/1/19 21:37
 * @Version 1.0
 * @Email cxc_work@163.com
 * jdbc 工具类  通过数据库连接池获取连接
 * 1. 提供连接防范
 * 2. 释放资源
 * 3. 获取连接池方法
 */
public class JDBCUtils {
    //定义一个成员变量
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 获取连接池
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * 释放资源
     */
    public static  void close(Statement statement,Connection connection){
      close(null,statement,connection);
    }
    /**
     * 释放资源
     */
    public static  void close(ResultSet resultSet, Statement statement, Connection connection){
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
