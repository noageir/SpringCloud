package com.micro.system.employee.service.impl;

import com.micro.system.employee.config.db.ReadOnlyConnection;
import com.micro.system.employee.config.db.WriteOnlyConnection;
import com.micro.system.employee.mapper.EmployeeMapper;
import com.micro.system.employee.model.form.user.AddUserForm;
import com.micro.system.employee.model.form.user.UserInfoForm;
import com.micro.system.employee.model.json.UserInfoJson;
import com.micro.system.employee.service.EmployeeService;
import com.micro.system.util.AesUtil;
import com.micro.system.util.SystemConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:15
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.service.impl
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private static Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

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
