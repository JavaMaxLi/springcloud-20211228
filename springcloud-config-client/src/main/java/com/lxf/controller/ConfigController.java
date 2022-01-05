package com.lxf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiXiaoFeng
 * @date 2022年01月05日 15:07
 */

@RestController
public class ConfigController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${server.port}")
    private String serverPort;
    @Value("${eureka.client.service-url.defaultZone}")
    private String eurekaServer;

    @RequestMapping("/getConfig")
    public String getConfig() {
        return "applicationName="+applicationName+",serverPort="+serverPort+",eurekaServer"+eurekaServer;
    }
}
