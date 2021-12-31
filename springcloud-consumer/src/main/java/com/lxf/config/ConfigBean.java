package com.lxf.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author LiXiaoFeng
 * @date 2021年12月29日 16:36
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced //Ribbon基于客户端负载均衡
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
