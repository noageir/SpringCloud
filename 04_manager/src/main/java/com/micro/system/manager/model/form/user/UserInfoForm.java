package com.micro.system.manager.model.form.user;

import com.micro.system.manager.util.BasePage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Size;

/**
 * @author Noageir
 * Date:2018-05-11 23:03
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.model.form
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserInfoForm extends BasePage {
    @ApiModelProperty(value = "用户名", example = "Test")
    @Size(max = 50, message = "用户名编码长度不能超过50个字符")
    private String userName;

    @ApiModelProperty(value = "密码", hidden = true)
    private String cipherPassWord;
}
