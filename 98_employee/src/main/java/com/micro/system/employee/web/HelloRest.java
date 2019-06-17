package com.micro.system.employee.web;

import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noageir
 * Date:2018-05-06 22:20
 * Project:com.spring.cloud
 * Package:com.micro.system.eureka
 */
@RestController
@RequestMapping("/employee_hello")
@Api(description = "测试类")
public class HelloRest {
    private static final Logger logger = LoggerFactory.getLogger(HelloRest.class);

    @GetMapping("/test")
    public String test() {
        return "Hello, I'm one";
    }
}
