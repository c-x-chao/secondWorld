package day19JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Author cxc
 * @Date 2021/1/19 22:28
 * @Version 1.0
 * @Email cxc_work@163.com
 * jdbcTemplate spring集成jdbc
 * 封装map集合
 */
public class JdbcTemplateDemo02 {
    public static void main(String[] args) {
        //创建jdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //调用方法
        String sql = "select * from account  where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 5);
        Set<String> set = map.keySet();
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }


    }
}
