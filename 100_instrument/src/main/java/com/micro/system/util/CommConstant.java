package com.micro.system.util;

import java.io.Serializable;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.util
 */
class CommConstant implements Serializable {
    static final ResponseCode SUCCESS = new ResponseCode("000000", "请求处理成功");

    static final ResponseCode SYSTEM_FAIL = new ResponseCode("-1", "系统异常, 请联系系统管理员");

    static final ResponseCode ARGUMENT_INVALID = new ResponseCode("-2", "请求参数错误");

    static final String SUCCESS_CODE = "000000";
    static final String SUCCESS_MESSAGE = "请求处理成功";
}
