package com.service.user;

import com.bean.user.RESTResultBean;
import com.bean.user.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LiXiaoFeng
 * @date 2021年12月30日 15:45
 */
@FeignClient(value = "springcloud-provider",fallbackFactory = UserFallbackFactory.class)//面向接口服务
@Component
public interface UserService {
    @GetMapping(value = "/user/search")
    RESTResultBean selectList(@RequestParam(value = "user",required = false) User user);//不使用@RequestParam GET请求会变成POST请求

    @PostMapping(value = "/user/add")
    boolean insertUser(User user);

    @PutMapping(value = "/user/edit")
    boolean updateUser(User user);

    @DeleteMapping(value = "/user/del")
    boolean deleteUser(User user);
}
