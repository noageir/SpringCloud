package com.micro.system.employee.mapper;

import com.micro.system.employee.model.form.user.AddUserForm;
import com.micro.system.employee.model.form.user.UserInfoForm;
import com.micro.system.employee.model.json.UserInfoJson;

import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:00
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.mapper
 */
public interface EmployeeMapper {
    /**
     * 查询用户信息
     *
     * @param userInfoForm 入参
     * @return 返参
     */
    List<UserInfoJson> queryUserInfo(UserInfoForm userInfoForm);

    /**
     * 新增用户信息
     *
     * @param addUserForm 入参
     * @return True or False
     */
    Boolean modifyUserInfo(AddUserForm addUserForm);

    /**
     * 删除用户信息
     *
     * @param userInfoForm 入参
     * @return True or False
     */
    Boolean removeUserInfo(UserInfoForm userInfoForm);
}
