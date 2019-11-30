package com.micro.system.zuul.model.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.zuul.model.form
 */
@Data
public class LoginForm {
    @ApiModelProperty(value = "登录账号", required = true, position = 1, example = "test001")
    @NotNull(message = "登录账号不能为空")
    @Size(min = 1, max = 20, message = "登录账号字符长度在1-20字符")
    private String userAccount;

    @ApiModelProperty(value = "密码", required = true, position = 2, example = "aaaaa000")
    @NotNull(message = "密码不能为空")
    @Size(min = 1, max = 20, message = "密码字符长度在1-20字符")
    private String userPwd;
}
