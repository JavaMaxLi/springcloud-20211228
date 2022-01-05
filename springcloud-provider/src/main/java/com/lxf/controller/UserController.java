package com.lxf.controller;

import com.bean.user.User;
import com.lxf.service.UserService;
import com.lxf.utils.EmptyHelper;
import com.lxf.utils.RESTResultBean;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
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
    @HystrixCommand(fallbackMethod = "searchUserFallback")
    public RESTResultBean searchUser(User user) {
        System.out.println("====user========"+user.toString());
        RESTResultBean result = new RESTResultBean();
        List<User> userList = userService.selectList(user);
        if (EmptyHelper.isEmpty(userList)) {
            throw new RuntimeException("没有数据");
        }
        result.setData(userList);
        return result;
    }

    /**
     * 熔断方法（参数需一致）
     * @param user
     * @return
     */
    public RESTResultBean searchUserFallback(User user) {
        RESTResultBean result = new RESTResultBean();
        result.setMessage("错误查询");
        result.setCode("1001");
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
