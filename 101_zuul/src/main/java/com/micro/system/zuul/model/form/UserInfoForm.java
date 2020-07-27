package com.micro.system.zuul.model.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;

/**
 * @author Noageir
 * Date:2018-05-11 23:03
 * Project:com.spring.cloud
 * Package:com.micro.system.manage.model.form
 */
@Data
public class UserInfoForm {
    @ApiModelProperty(value = "用户名", example = "Test")
    @Size(max = 50, message = "用户名编码长度不能超过50个字符")
    private String userName;

    @ApiModelProperty(value = "密码", hidden = true)
    private String cipherPassWord;
}
