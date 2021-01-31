package com.micro.system.signalling;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringCloudApplication
@EnableFeignClients
@EnableAsync
@Log4j2
public class SignallingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SignallingApplication.class, args);
    }
}
