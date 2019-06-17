package com.micro.system.employee.web;

import com.micro.system.employee.service.RedisService;
import com.micro.system.util.ReturnJson;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.concurrent.TimeUnit.SECONDS;

@RestController
@RequestMapping("/redis")
@Api(description = "Redis工具接口")
public class RedisRest {
    private static final String REDIS_FLAG = "Test_Redis";

    @Autowired
    private RedisService redisService;

    @GetMapping("/add")
    public ReturnJson add() {
        redisService.setValueForString(REDIS_FLAG, "123", 30, SECONDS);
        return ReturnJson.success();
    }


    @GetMapping("/query")
    public ReturnJson query() {
        String str = redisService.getValueForString(REDIS_FLAG);
        return ReturnJson.success(str);
    }

}
