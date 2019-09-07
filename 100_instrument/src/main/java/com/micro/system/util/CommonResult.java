package com.micro.system.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.util
 */
@Data
class CommonResult implements Serializable {
    /**
     * 异常类
     */
    private String exceptionName;
    /**
     * 错误原因
     */
    private String errorMessage;
    /**
     * 异常堆栈信息
     */
    private String stackTrace;
}