package com.micro.system.manager.service.impl;

import com.micro.system.manager.batch.EmployeeBatchService;
import com.micro.system.manager.config.db.ReadOnlyConnection;
import com.micro.system.manager.config.db.WriteOnlyConnection;
import com.micro.system.manager.constant.ManagerConstant;
import com.micro.system.manager.mapper.EmployeeMapper;
import com.micro.system.manager.model.entity.AddUser;
import com.micro.system.manager.model.form.user.AddUserForm;
import com.micro.system.manager.model.form.user.UserInfoForm;
import com.micro.system.manager.model.json.UserInfoJson;
import com.micro.system.manager.service.EmployeeService;
import com.micro.system.util.AesUtil;
import com.micro.system.util.CommonException;
import com.micro.system.util.SystemConstant;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    private final EmployeeBatchService employeeBatchService;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, EmployeeBatchService employeeBatchService) {
        this.employeeMapper = employeeMapper;
        this.employeeBatchService = employeeBatchService;
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
        AddUser addUser = new AddUser();
        addUser.setUserName(userInfoForm.getUserName());
        return employeeMapper.removeUserInfo(addUser);
    }

    @Override
    @ReadOnlyConnection
    public List<UserInfoJson> queryUserInfo(UserInfoForm userInfoForm) {
        return employeeMapper.queryUserInfo(userInfoForm);
    }

    @Override
    public void modifyUserInfoBatch() {
        List<AddUser> userLists = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            AddUser addUser = new AddUser();
            addUser.setUserName("Tom" + i);
            addUser.setUserPassword(AesUtil.encrypt("123456", SystemConstant.SECRET_KEY));
            addUser.setGender("F");
            addUser.setUserAge(25);
            addUser.setPhone("13512345678");
            addUser.setAddress("上海市浦东新区");
            userLists.add(addUser);
        }
        batchGenerateInfo(userLists);
    }

    private void batchGenerateInfo(List<AddUser> userLists) {
        try {
            log.info("Start Write User Info...");
            doBatch(userLists);
            log.info("End Write User Info...");
        } catch (CommonException e) {
            log.info("Clear user Info Start...");
            //回退客户信息
            employeeBatchService.moveUserInfoBath(userLists);
            log.info("Clear user Info End...");
        }
    }

    private void doBatch(List<AddUser> userLists) throws CommonException {
        try {
            employeeBatchService.addUserInfoBath(userLists);
        } catch (Exception e) {
            throw new CommonException(ManagerConstant.RESULT_NULL);
        }
    }
}
