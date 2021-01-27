package day19JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

/**
 * @Author cxc
 * @Date 2021/1/19 22:28
 * @Version 1.0
 * @Email cxc_work@163.com
 * jdbcTemplate spring集成jdbc
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //创建jdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "update account set moeny = 5000 where id = ?";
        int count = template.update(sql,6);
        System.out.println(count);
    }
}
