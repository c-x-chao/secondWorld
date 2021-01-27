package day19JdbcTemplate;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;
import java.util.Map;

/**
 * @Author cxc
 * @Date 2021/1/19 22:28
 * @Version 1.0
 * @Email cxc_work@163.com
 * jdbcTemplate spring集成jdbc
 * 封装成实体类
 */
public class JdbcTemplateDemo04 {
    public static void main(String[] args) {
        //创建jdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "select * from account ";
        List<Account> list = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : list) {
            System.out.println(account);
        }

    }
}
