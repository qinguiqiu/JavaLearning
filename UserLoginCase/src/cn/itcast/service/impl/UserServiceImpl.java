package cn.itcast.service.impl;

import cn.itcast.dao.UserDao;
import cn.itcast.dao.impl.UserDaoImpl;
import cn.itcast.domain.PageBean;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0){
            for (String id : ids) {
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<User> findUserPage(String _currentPage, String _rows, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        PageBean<User> pb = new PageBean<>();

        int totalCount = dao.findTotalCount(condition);

        int totalPage = totalCount % rows == 0 ? totalCount/rows : totalCount/rows + 1;

        if (currentPage <= 0){
            currentPage = 1;
        }

        if (currentPage >= totalPage){
            currentPage = totalPage;
        }

        int start = (currentPage - 1) * rows;
        if(totalPage <= 0){
            start = 0;
        }
        List<User> list = dao.findByPage(start, rows, condition);

        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        pb.setTotalCount(totalCount);
        pb.setList(list);
        pb.setTotalPage(totalPage);

        return pb;
    }


}
