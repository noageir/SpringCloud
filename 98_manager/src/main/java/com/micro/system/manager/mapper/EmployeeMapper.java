package com.micro.system.manager.mapper;

import com.micro.system.manager.model.entity.AddUser;
import com.micro.system.manager.model.form.user.UserInfoForm;
import com.micro.system.manager.model.json.UserInfoJson;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:00
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.mapper
 */
@Mapper
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
    Boolean modifyUserInfo(AddUser addUser);

    /**
     * 删除用户信息
     *
     * @param userInfoForm 入参
     * @return True or False
     */
    Boolean removeUserInfo(UserInfoForm userInfoForm);
}
