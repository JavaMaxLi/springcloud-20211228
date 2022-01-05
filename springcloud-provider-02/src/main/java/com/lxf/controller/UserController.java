package com.lxf.controller;

import com.bean.user.User;
import com.lxf.service.UserService;
import com.lxf.utils.EmptyHelper;
import com.lxf.utils.RESTResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 14:18
 * 提供Restful服务
 */
@RestController
@RequestMapping(value = "/user")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 查询用户
     * @param user
     * @return
     */
    @GetMapping(value = "/search")
    public RESTResultBean searchUser(User user) {
        System.out.println("====user========"+user.toString());
        RESTResultBean result = new RESTResultBean();
        result.setData(userService.selectList(user));
        return result;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "/add")
    public RESTResultBean addUser(User user) {
        RESTResultBean result = new RESTResultBean();
        System.out.println("====user========"+user);
        result.setData(userService.insertUser(user));
        return result;
    }

    /**
     * 编辑用户
     * @param user
     * @return
     */
    @PutMapping(value = "/edit")
    public RESTResultBean editUser(User user) {
        RESTResultBean result = new RESTResultBean();
        result.setData(userService.updateUser(user));
        return result;
    }

    /**
     * 删除用户
     * @param user
     * @return
     */
    @DeleteMapping(value = "/del")
    public RESTResultBean delUser(User user) {
        RESTResultBean result = new RESTResultBean();
        result.setData(userService.deleteUser(user));
        return result;
    }
    private static int st = 0;// 静态的
    private int index = 0;// 非静态的
    private ReentrantLock lock = new ReentrantLock();
    @GetMapping(value = "/test")
    public void test() {
        System.out.println(st++ + "|" + index++ +"|" + lock);
        ReentrantLock lock = new ReentrantLock();
        System.out.println("lock="+lock);
    }

}
