package com.micro.system.zuul.model.json;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Noageir
 * Date:2018-05-11 23:05
 * Project:com.spring.cloud
 * Package:com.micro.system.manage.model.json
 */
@Data
public class UserInfoJson {
    @ApiModelProperty(value = "序号")
    private long id;

    @ApiModelProperty(value = "用户名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private int age;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "联系方式")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;
}
