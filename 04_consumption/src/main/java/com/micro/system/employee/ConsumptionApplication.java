package com.micro.system.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Noageir
 * Date:2018-05-11 22:02
 * Project:com.spring.cloud
 * Package:com.micro.system.employee
 */
@SpringCloudApplication
@EnableFeignClients
public class ConsumptionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumptionApplication.class, args);
    }

}
