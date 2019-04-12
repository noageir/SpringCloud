package com.micro.system.gateway.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noageir
 * Date:2018-05-11 23:11
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.web
 */
@RestController
@RequestMapping("/gateway_hello")
public class HelloRest {
    private static final Logger logger = LoggerFactory.getLogger(HelloRest.class);

    @GetMapping("/test")
    public String test() {
        return "ok";
    }

}
