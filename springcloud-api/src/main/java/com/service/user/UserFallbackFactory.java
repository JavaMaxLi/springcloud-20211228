package com.service.user;

import com.bean.user.RESTResultBean;
import com.bean.user.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author LiXiaoFeng
 * @date 2021年12月31日 15:15
 */
@Component
public class UserFallbackFactory implements FallbackFactory<UserService> {
    @Override
    public UserService create(Throwable throwable) {
        return new UserService() {
            @Override
            public RESTResultBean selectList(User user) {
                RESTResultBean result = new RESTResultBean();
                result.setMessage("客户端对该服务进行降级，已经被关闭，无法服务");
                return result;
            }

            @Override
            public boolean insertUser(User user) {
                return false;
            }

            @Override
            public boolean updateUser(User user) {
                return false;
            }

            @Override
            public boolean deleteUser(User user) {
                return false;
            }
        };
    }
}
