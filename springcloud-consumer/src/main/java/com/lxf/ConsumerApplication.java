package com.lxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 16:46
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.service"})
@ComponentScan({"com.service","com.lxf"})
//@RibbonClient(name = "springcloud-provider",configuration = ConfigBean.class) 自定义Ribbon负载均衡策略
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
