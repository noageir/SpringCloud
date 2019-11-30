package com.micro.system.zuul.feign;

import com.micro.system.util.ReturnJson;
import com.micro.system.zuul.config.FeignClientConfiguration;
import com.micro.system.zuul.model.form.UserInfoForm;
import com.micro.system.zuul.model.json.UserInfoJson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "manage-server", configuration = FeignClientConfiguration.class, path = "/manage-server", fallback = ManagerClientFallBack.class)
public interface ManagerClient {
    @PostMapping(value = "/employee/query_user_info_pri")
    ReturnJson<UserInfoJson> queryEmployeeInfo(@RequestBody UserInfoForm userInfoForm);

}
