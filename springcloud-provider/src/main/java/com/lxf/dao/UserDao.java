package com.lxf.dao;

import com.bean.user.User;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 14:19
 */
public interface UserDao {
    List<User> selectList(User user);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(User user);
}
