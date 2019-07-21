package com.micro.system.zuul.service.impl;

import com.micro.system.util.AesUtil;
import com.micro.system.util.ReturnJson;
import com.micro.system.util.SystemConstant;
import com.micro.system.zuul.feign.ManagerClient;
import com.micro.system.zuul.model.form.LoginForm;
import com.micro.system.zuul.model.form.UserInfoForm;
import com.micro.system.zuul.model.json.UserInfoJson;
import com.micro.system.zuul.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private ManagerClient managerClient;

    @Override
    public Boolean login(LoginForm loginForm) {
        UserInfoJson userInfoJson = getEmployeeInfo(loginForm);
        return null != userInfoJson;
    }

    /**
     * 获取员工信息
     */
    private UserInfoJson getEmployeeInfo(LoginForm loginForm) {
        UserInfoForm userInfoForm = new UserInfoForm();
        UserInfoJson userInfoJson = new UserInfoJson();
        userInfoForm.setUserName(loginForm.getUserAccount());
        String password = AesUtil.encrypt(loginForm.getUserPwd(), SystemConstant.SECRET_KEY);
        userInfoForm.setCipherPassWord(password);
        ReturnJson<UserInfoJson> returnJson = managerClient.queryEmployeeInfo(userInfoForm);
        if (returnJson.isSuccess()) {
            userInfoJson = returnJson.getData();
        }
        return userInfoJson;
    }
}
