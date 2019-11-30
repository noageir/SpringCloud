package com.micro.system.zuul.web;

import com.micro.system.util.ReturnJson;
import com.micro.system.zuul.model.form.LoginForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.zuul.web
 */
@RestController
@Log4j2
@RequestMapping("/valid")
@Api(tags = "登录")
public class LoginRest {

    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "验证账户和密码等信息，返回验证结果", response = Boolean.class)
    public ReturnJson loginSystem(@Validated @RequestBody LoginForm loginForm) {
        return ReturnJson.success(true);
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登出", notes = "注销当前登录账户，清理缓存信息", response = Boolean.class)
    public ReturnJson logoutSystem() {


        return ReturnJson.success(true);
    }


}
