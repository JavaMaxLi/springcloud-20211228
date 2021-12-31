package com.lxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 15:16
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lxf.dao"})
@EnableEurekaClient
public class ProviderApplication03 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication03.class,args);
    }
}
