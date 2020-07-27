package com.micro.system.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.zuul
 */
@SpringCloudApplication
@EnableZuulProxy
@EnableFeignClients
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
