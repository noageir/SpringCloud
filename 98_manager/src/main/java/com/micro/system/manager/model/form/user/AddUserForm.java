package com.micro.system.manager.model.form.user;

import com.micro.system.manager.util.Multiple;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Noageir
 * Date:2018-05-13 10:30
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.model.form
 */
@Data
public class AddUserForm {
    @ApiModelProperty(value = "用户名", example = "Test", required = true, position = 1)
    @NotNull(message = "用户名不能为空")
    @Size(min = 1, max = 50, message = "用户名编码长度在1-50个字符之间")
    private String userName;

    @ApiModelProperty(value = "密码", example = "123456", required = true, position = 2)
    @NotNull(message = "密码不能为空")
    @Size(min = 6, max = 50, message = "密码编码长度在6-200个字符之间")
    private String userPassword;

    @ApiModelProperty(value = "年龄", example = "28", allowableValues = "range[1,999]", position = 3)
    @Max(value = 999, message = "年龄编码长度在1-999个字符之间")
    private int userAge;

    @ApiModelProperty(value = "性别", example = "F", allowableValues = "M,F", position = 4)
    @Size(max = 5, message = "性别编码长度在1-5个字符之间")
    @Multiple(value = {"M", "F"}, message = "性别输入错误")
    private String gender;

    @ApiModelProperty(value = "联系方式", example = "13512345678", position = 5)
    @Size(max = 20, message = "联系方式编码长度在1-20个字符之间")
    private String phone;

    @ApiModelProperty(value = "地址", example = "上海市浦东新区", position = 6)
    @Size(max = 200, message = "地址编码长度在1-200个字符之间")
    private String address;

    @ApiModelProperty(value = "数量", hidden = true, position = 7)
    private int count;
}
