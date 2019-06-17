package com.micro.system.employee.config;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfiguration {

    @Bean
    public RequestInterceptor feignClientRequestInterceptor() {
        return new FeignClientRequestInterceptor();
    }

}