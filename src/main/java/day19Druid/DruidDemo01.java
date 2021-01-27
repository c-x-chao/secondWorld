package day19Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.transform.Source;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.util.Properties;

/**
 * @Author cxc
 * @Date 2021/1/19 21:27
 * @Version 1.0
 * @Email cxc_work@163.com
 * Druid 数据库连接池
 */
public class DruidDemo01 {
    public static void main(String[] args) throws Exception {
        //加载配置文件
        Properties pro = new Properties();
        InputStream is = DruidDemo01.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
        //获取连接池对象
        Connection conn = dataSource.getConnection();
        System.out.println(conn);

    }
}
