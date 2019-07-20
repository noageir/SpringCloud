package com.micro.system.manager.model.entity;

import com.micro.system.util.Entity;
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
    private String userName;

    private String userPassword;

    private int userAge;

    private String gender;

    private String phone;

    private String address;

    private int count;
}
