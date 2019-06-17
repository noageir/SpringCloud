package com.micro.system.employee.feign;

import com.micro.system.util.ResponseCode;
import org.springframework.stereotype.Component;

@Component
public class EmployeeClientFallBack implements EmployeeClient {

    private static final ResponseCode QUALIFICATION_CHECK_FAIL_CTS = new ResponseCode("0000001", "微服务调用失败");

    @Override
    public String employeeTest() {
        return "微服务调用失败";
    }
}
