package com.lxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author LiXiaoFeng
 * @date 2022年01月04日 11:06
 */

@SpringBootApplication
@EnableHystrixDashboard//开启配置
public class DashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(DashboardApplication.class,args);
    }
}
