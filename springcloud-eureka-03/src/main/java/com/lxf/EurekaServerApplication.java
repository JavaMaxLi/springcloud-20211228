package com.lxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author LiXiaoFeng
 * @date 2021年12月30日 10:03
 */
@SpringBootApplication
@EnableEurekaServer//服务端启动类，可以接收别人的注册
public class EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerApplication.class,args);
    }
}
