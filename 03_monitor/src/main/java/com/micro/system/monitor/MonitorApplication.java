package com.micro.system.monitor;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @author Noageir
 * Date:2018-05-06 22:20
 * Project:com.spring.cloud
 * Package:com.micro.system.eureka
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class MonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitorApplication.class, args);
    }
}
