package com.micro.system.zuul.feign;

import com.micro.system.util.ResponseCode;
import com.micro.system.util.ReturnJson;
import com.micro.system.zuul.model.form.UserInfoForm;
import com.micro.system.zuul.model.json.UserInfoJson;
import org.springframework.stereotype.Component;

@Component
public class ManagerClientFallBack implements ManagerClient {

    private static final ResponseCode QUALIFICATION_CHECK_FAIL = new ResponseCode("1000001", "ManagerServer调用失败");

    @Override
    public ReturnJson<UserInfoJson> queryEmployeeInfo(UserInfoForm userInfoForm) {
        return ReturnJson.json(QUALIFICATION_CHECK_FAIL);
    }
}
