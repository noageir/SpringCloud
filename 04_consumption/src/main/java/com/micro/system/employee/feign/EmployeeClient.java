package com.micro.system.employee.feign;

import com.micro.system.employee.config.FeignClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "employee-server", path = "/", configuration = FeignClientConfiguration.class, fallback = EmployeeClientFallBack.class)
public interface EmployeeClient {
    @GetMapping(value = "/employee_hello/test")
    String employeeTest();
}
