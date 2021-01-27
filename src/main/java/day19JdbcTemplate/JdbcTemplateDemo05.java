package day19JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.List;

/**
 * @Author cxc
 * @Date 2021/1/19 22:28
 * @Version 1.0
 * @Email cxc_work@163.com
 * jdbcTemplate spring集成jdbc
 * 统计总数
 */
public class JdbcTemplateDemo05 {
    public static void main(String[] args) {
        //创建jdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "select count(1) from account ";
        //执行聚合函数的
        Long aLong = template.queryForObject(sql, long.class);
        System.out.println(aLong);

    }
}
