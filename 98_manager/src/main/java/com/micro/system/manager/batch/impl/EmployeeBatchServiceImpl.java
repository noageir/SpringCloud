package com.micro.system.manager.batch.impl;

import com.micro.system.manager.batch.EmployeeBatchService;
import com.micro.system.manager.model.entity.AddUser;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Noageir
 * Date: 2019-11-30
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.batch.impl
 */
@Service
public class EmployeeBatchServiceImpl extends BaseDAO implements EmployeeBatchService {
    @Override
    public void addUserInfoBath(List<AddUser> userList) {
        super.batchInsert("saveUserInfo", userList);
    }

    @Override
    public void moveUserInfoBath(List<AddUser> userList) {
        super.batchInsert("removeUserInfo", userList);
    }
}
