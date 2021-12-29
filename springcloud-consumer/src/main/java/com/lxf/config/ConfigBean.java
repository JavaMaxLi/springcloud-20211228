package com.lxf.config;

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
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
