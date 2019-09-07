package com.micro.system.manager.service.impl;

import com.micro.system.manager.config.db.ReadOnlyConnection;
import com.micro.system.manager.config.db.WriteOnlyConnection;
import com.micro.system.manager.mapper.EmployeeMapper;
import com.micro.system.manager.model.entity.AddUser;
import com.micro.system.manager.model.form.user.AddUserForm;
import com.micro.system.manager.model.form.user.UserInfoForm;
import com.micro.system.manager.model.json.UserInfoJson;
import com.micro.system.manager.service.EmployeeService;
import com.micro.system.util.AesUtil;
import com.micro.system.util.SystemConstant;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:15
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.service.impl
 */
@Service
@Log4j2
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    @WriteOnlyConnection
    public Boolean modifyUserInfo(AddUserForm addUserForm) {
        AddUser addUser = new AddUser();
        BeanUtils.copyProperties(addUserForm, addUser);
        addUser.setUserPassword(AesUtil.encrypt(addUserForm.getUserPassword(), SystemConstant.SECRET_KEY));
        return employeeMapper.modifyUserInfo(addUser);
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
