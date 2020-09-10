package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {
    //查询所有用户信息
    public List<User> findAll();

    public User login(User user);

    public void addUser(User user);

    public void deleteUser(String id);

    public User findUserById(String id);

    public void updateUser(User user);

    public void delSelectedUser(String[] ids);
}
