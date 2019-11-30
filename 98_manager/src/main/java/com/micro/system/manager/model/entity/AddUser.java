package com.micro.system.manager.model.entity;

import com.micro.system.util.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created on 2019/7/19.
 *
 * @author Noageir
 * com.spring.cloud
 * com.micro.system.manager.model.entity
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class AddUser extends Entity {
    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String userPassword;

    @ApiModelProperty(value = "性别")
    private int userAge;

    @ApiModelProperty(value = "年龄")
    private String gender;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "地址")
    private String address;

    @ApiModelProperty(hidden = true)
    private int count;
}
