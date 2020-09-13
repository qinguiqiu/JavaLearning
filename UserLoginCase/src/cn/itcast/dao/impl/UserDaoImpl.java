package cn.itcast.dao.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.domain.User;
import cn.itcast.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDatasource());

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        return users;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        try{
            String sql = "select * from user where username = username and password = password";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
            return user;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void add(User user) {
        String sql = "insert into user values(null,?,?,?,?,?,?,null,null)";
        try {
            template.update(sql, user.getName().getBytes(), user.getGender().getBytes(), user.getAge(),
                    user.getAddress().getBytes(), user.getQq(), user.getEmail());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "delete from user where id = ?";
        template.update(sql, id);
    }

    @Override
    public User findById(int id) {
        String sql = "select * from user where id = ?";
        User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update user set name = ?, gender = ?, age = ?, address = ?, qq = ?, email = ? where id =?";
        template.update(sql,user.getName().getBytes(),user.getGender().getBytes(),user.getAge(),
                user.getAddress().getBytes(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql = "select count(*) from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        sql = sb.toString();
        return template.queryForObject(sql, Integer.class, params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from user where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<>();
        for (String key : keySet) {
            if("currentPage".equals(key) || "rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value != null && !"".equals(value)){
                sb.append(" and "+key+" like ? " );
                params.add("%"+value+"%");
            }
        }
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        System.out.println(sb.toString());
        System.out.println(params);
        sql = sb.toString();
        return template.query(sql, new BeanPropertyRowMapper<>(User.class),params.toArray());
    }
}
