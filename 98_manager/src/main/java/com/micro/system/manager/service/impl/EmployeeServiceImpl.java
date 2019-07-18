package com.micro.system.manager.service.impl;

import com.micro.system.manager.config.db.ReadOnlyConnection;
import com.micro.system.manager.config.db.WriteOnlyConnection;
import com.micro.system.manager.mapper.EmployeeMapper;
import com.micro.system.manager.model.form.user.AddUserForm;
import com.micro.system.manager.model.form.user.UserInfoForm;
import com.micro.system.manager.model.json.UserInfoJson;
import com.micro.system.manager.service.EmployeeService;
import com.micro.system.util.AesUtil;
import com.micro.system.util.SystemConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:15
 * Project:com.spring.cloud
 * Package:com.micro.system.consumption.service.impl
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    @WriteOnlyConnection
    public Boolean modifyUserInfo(AddUserForm addUserForm) {
        addUserForm.setUserPassword(AesUtil.encrypt(addUserForm.getUserPassword(), SystemConstant.SECRET_KEY));
        return employeeMapper.modifyUserInfo(addUserForm);
    }

    @Override
    @WriteOnlyConnection
    public Boolean removeUserInfo(UserInfoForm userInfoForm) {
        return employeeMapper.removeUserInfo(userInfoForm);
    }

    @Override
    @ReadOnlyConnection
    public List<UserInfoJson> queryUserInfo(UserInfoForm userInfoForm) {
        return employeeMapper.queryUserInfo(userInfoForm);
    }
}
