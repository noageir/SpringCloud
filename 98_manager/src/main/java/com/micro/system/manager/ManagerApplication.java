package com.micro.system.manager;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Noageir
 * Date:2018-05-11 22:02
 * Project:com.spring.cloud
 * Package:com.micro.system.consumption
 */
@SpringCloudApplication
@EnableFeignClients
@Slf4j
@MapperScan(value = "com.micro.system.manager.mapper")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}
