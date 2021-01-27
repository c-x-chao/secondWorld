package day18jdbc;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * @Author cxc
 * @Date 2021/1/18 21:54
 * @Version 1.0
 * @Email cxc_work@163.com
 */
public class DBUtils {
    private static Connection conn = null;
    private static PreparedStatement start = null;
    private static String DRIVER = null;
    private static String URL = null;
    private static String USERNAME = null;
    private static String PASSWORD = null;

    static {
        try {
            Properties pro = new Properties();
            ClassLoader classLoader = DBUtils.class.getClassLoader();
            URL res = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            pro.load(new FileReader(path));
            DRIVER = pro.getProperty("jdbc.driver");
            URL = pro.getProperty("jdbc.url");
            USERNAME = pro.getProperty("jdbc.username");
            PASSWORD = pro.getProperty("jdbc.password");
            Class.forName(DRIVER);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    /**
     * 释放资源
     */
    public static void close(Statement statement, Connection conn) {
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

    /**
     * 释放资源
     */
    public static void close(ResultSet rs, Statement statement, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
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

    public static void main(String[] args) {
//        System.out.println(1);
//        try {
//            Connection connection = DBUtils.getConnection();
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        System.out.println();
    }
}
