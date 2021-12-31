package com.lxf.controller;

import com.bean.user.RESTResultBean;
import com.bean.user.User;
import com.lxf.utils.EmptyHelper;
import com.netflix.discovery.converters.Auto;
import com.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 15:49
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserService userService;

    /**
     * RestTemplate 使用
     * @param user
     * @return
     */
    @RequestMapping("/search")
    public RESTResultBean searchUser(User user) {
        //RESTResultBean result = new RESTResultBean();
        Map<String,Object> param = new HashMap<>();
        if (EmptyHelper.isNotEmpty(user.getName())) {
            param.put("name",user.getName());
        }
        if (EmptyHelper.isNotEmpty(user.getIdCard())) {
            param.put("idCard",user.getIdCard());
        }
        if (EmptyHelper.isNotEmpty(user.getPuk())) {
            param.put("puk",user.getPuk());
        }
        RESTResultBean result = restTemplate.getForObject("http://SPRINGCLOUD-PROVIDER/user/search", RESTResultBean.class, param);
        return result;
    }

    @RequestMapping("/add")
    public RESTResultBean addUser(User user) {
        System.out.println(user);
        RESTResultBean restResultBean = restTemplate.postForObject("http://localhost:8001/user/add", user, RESTResultBean.class);

        return restResultBean;
    }


    /**
     * Feign 使用
     * @param user
     * @return
     */
    @RequestMapping("/searchFeign")
    public RESTResultBean searchUserWithFeign(User user) {
        //RESTResultBean result = new RESTResultBean();
        RESTResultBean result = userService.selectList(user);
        //result.setData(users);
        return result;
    }
}
