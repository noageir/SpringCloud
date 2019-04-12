package com.micro.system.employee.web;

import com.github.pagehelper.PageInfo;
import com.micro.system.employee.constant.ManageConstant;
import com.micro.system.employee.model.form.user.AddUserForm;
import com.micro.system.employee.model.form.user.UserInfoForm;
import com.micro.system.employee.model.json.UserInfoJson;
import com.micro.system.employee.service.EmployeeService;
import com.micro.system.util.CommonException;
import com.micro.system.util.ReturnJson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Noageir
 * Date:2018-05-11 23:11
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.web
 */
@RestController
@RequestMapping("/employee")
@Api(description = "员工信息管理")
public class EmployeeRest {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeRest.class);

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/query_user_info")
    @ApiOperation(value = "查询用户信息", notes = "通过入参筛选符合要求的用户信息，返回结果", response = UserInfoJson.class)
    public ReturnJson queryUserInfo(@RequestBody UserInfoForm userInfoForm) {
        List<UserInfoJson> userInfo = employeeService.queryUserInfo(userInfoForm);
        PageInfo<UserInfoJson> info = new PageInfo<>(userInfo);
        return ReturnJson.success(info);
    }

    @PostMapping("/query_user_info_pri")
    @ApiOperation(value = "查询用户信息", notes = "通过入参筛选符合要求的用户信息，返回结果", response = UserInfoJson.class)
    public ReturnJson queryUserInfoPri(@RequestBody UserInfoForm userInfoForm) {
        List<UserInfoJson> userInfo = employeeService.queryUserInfo(userInfoForm);
        if (CollectionUtils.isEmpty(userInfo)) {
            throw new CommonException(ManageConstant.RESULT_NULL);
        }
        return ReturnJson.success(userInfo);
    }

    @PostMapping("/modify_user_info")
    @ApiOperation(value = "新增或修改用户信息", notes = "通过入参添加或修改用户信息，返回结果", response = Boolean.class)
    public ReturnJson modifyUserInfo(@Valid @RequestBody AddUserForm addUserForm) {
        return ReturnJson.success(employeeService.modifyUserInfo(addUserForm));
    }

    @PostMapping("/remove_user_info")
    @ApiOperation(value = "删除用户信息", notes = "通过入参删除用户信息，返回结果", response = Boolean.class)
    public ReturnJson removeUserInfo(@Valid @RequestBody UserInfoForm userInfoForm) {
        return ReturnJson.success(employeeService.removeUserInfo(userInfoForm));
    }

}
