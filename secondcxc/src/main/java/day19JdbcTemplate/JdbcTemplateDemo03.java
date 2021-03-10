package day19JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author cxc
 * @Date 2021/1/19 22:28
 * @Version 1.0
 * @Email cxc_work@163.com
 * jdbcTemplate spring集成jdbc
 * 封装List集合
 */
public class JdbcTemplateDemo03 {
    public static void main(String[] args) {
        //创建jdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "select * from account ";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            System.out.println(map);
        }


    }
}
