package com.lxf.service.impl;

import com.bean.user.User;
import com.lxf.dao.UserDao;
import com.lxf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 15:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectList(User user) {
        return userDao.selectList(user);
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return userDao.deleteUser(user);
    }
}
