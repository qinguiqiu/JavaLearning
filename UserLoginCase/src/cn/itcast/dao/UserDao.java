package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username, String password);

    public void add(User user);

    public void delete(int id);

    public User findById(int id);

    public void update(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
