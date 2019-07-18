package com.micro.system.manager.constant;

import com.micro.system.util.ResponseCode;

import java.io.Serializable;

/**
 * @author Noageir
 * Date: 2018-05-20
 * Project: com.spring.cloud
 * Package: com.micro.system.consumption.constant
 */
public class ManageConstant implements Serializable {
    /**
     * 错误码
     */
    public static final ResponseCode RESULT_NULL = new ResponseCode("Me1000001", "查询无数据");

}
