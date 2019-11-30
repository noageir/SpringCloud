package com.micro.system.manager.batch;

import com.micro.system.manager.model.entity.AddUser;

import java.util.List;

/**
 * @author Noageir
 * Date: 2019-11-30
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.mapper
 */
public interface EmployeeBatchService {
    //批量保存用户
    void addUserInfoBath(List<AddUser> userList);

    //批量删除
    void moveUserInfoBath(List<AddUser> userList);
}


