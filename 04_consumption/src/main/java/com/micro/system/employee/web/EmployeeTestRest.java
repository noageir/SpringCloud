package com.micro.system.employee.web;

import com.micro.system.employee.feign.EmployeeClient;
import com.micro.system.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Noageir
 * Date:2018-05-11 23:11
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.web
 */
@RestController
@RequestMapping("/employee_test")
@Api(description = "员工信息管理")
public class EmployeeTestRest {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeTestRest.class);

    @Autowired
    public EmployeeClient employeeClient;

    @GetMapping("/employee_test")
    @ApiOperation(value = "测试客户管理系统", notes = "测试客户管理系统", response = String.class)
    public ReturnJson test() {
        return ReturnJson.success(employeeClient.employeeTest());
    }


    @GetMapping("/employee_test_hello")
    @ApiOperation(value = "测试客户管理系统", notes = "测试客户管理系统", response = String.class)
    public String testHello() {
        return "Hello";
    }
}
