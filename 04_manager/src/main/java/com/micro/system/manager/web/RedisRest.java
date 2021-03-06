package com.micro.system.manager.web;

import com.micro.system.manager.service.RedisService;
import com.micro.system.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.concurrent.TimeUnit.SECONDS;

@RestController
@RequestMapping("/redis")
@Api(tags = "03-Redis工具接口")
public class RedisRest {
    private static final String REDIS_FLAG = "Test_Redis";

    private final RedisService redisService;

    public RedisRest(RedisService redisService) {
        this.redisService = redisService;
    }

    @GetMapping("/add")
    @ApiOperation(value = "新增缓存信息", response = boolean.class)
    public ReturnJson add() {
        redisService.setValueForString(REDIS_FLAG, "123", 30, SECONDS);
        return ReturnJson.success();
    }


    @GetMapping("/query")
    @ApiOperation(value = "查询缓存信息", response = String.class)
    public ReturnJson query() {
        String str = redisService.getValueForString(REDIS_FLAG);
        return ReturnJson.success(str);
    }

}
