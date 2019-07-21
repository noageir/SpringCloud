package com.micro.system.zuul.web;

import com.micro.system.util.ReturnJson;
import com.micro.system.zuul.model.form.LoginForm;
import com.micro.system.zuul.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/valid")
@Api(description = "登录")
public class LoginRest {
    private static final Logger logger = LoggerFactory.getLogger(LoginRest.class);

    private final LoginService loginService;

    @Autowired
    public LoginRest(LoginService loginService) {
        this.loginService = loginService;
    }


    @PostMapping("/login")
    @ApiOperation(value = "登录", notes = "验证账户和密码等信息，返回验证结果", response = Boolean.class)
    public ReturnJson loginSystem(@Validated @RequestBody LoginForm loginForm) {
        return ReturnJson.success(loginService.login(loginForm));
    }

    @PostMapping("/logout")
    @ApiOperation(value = "登录", notes = "测试", response = Boolean.class)
    public ReturnJson logoutSystem() {


        return ReturnJson.success(true);
    }


}
