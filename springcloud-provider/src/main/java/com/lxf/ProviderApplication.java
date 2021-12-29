package com.lxf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 15:16
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.lxf.dao"})
public class ProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProviderApplication.class,args);
    }
}
