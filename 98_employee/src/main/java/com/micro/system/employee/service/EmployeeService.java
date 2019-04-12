package com.micro.system.employee.service;

import com.micro.system.employee.model.form.user.AddUserForm;
import com.micro.system.employee.model.form.user.UserInfoForm;
import com.micro.system.employee.model.json.UserInfoJson;

import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:14
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.service
 */
public interface EmployeeService {
    /**
     * 新增用户信息
     *
     * @param addUserForm 用户参数
     * @return Boolean
     */
    Boolean modifyUserInfo(AddUserForm addUserForm);

    /**
     * 删除用户信息
     *
     * @param userInfoForm 用户参数
     * @return Boolean
     */
    Boolean removeUserInfo(UserInfoForm userInfoForm);

    /**
     * 查询用户信息
     *
     * @param userInfoForm 查询参数
     * @return 用户信息
     */
    List<UserInfoJson> queryUserInfo(UserInfoForm userInfoForm);


}
