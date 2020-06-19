package com.micro.system.manager.web;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

/**
 * @author Noageir
 * Date:2018-05-06 22:20
 * Project:com.spring.cloud
 * Package:com.micro.system.eureka
 */
@RestController
@RequestMapping("/hello")
@Log4j2
@Api(tags = "00-测试类")
public class HelloRest {

    @PostMapping("/hello")
    public String testPost() {
        return "Hello, I'm Test";
    }

    @GetMapping("/hello/{message}")
    public String testGet(@PathVariable("message") String message) {
        return "Hello, I'm Test..." + message;
    }
}
