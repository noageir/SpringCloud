package com.micro.system.util;

import lombok.Data;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.util
 */
@Data
class ArgumentInvalidResult {
    /**
     * 异常类
     */
    private String exceptionName;
    /**
     * 错误原因
     */
    private String errorMessage;
    /**
     * 异常字段
     */
    private String fieldCode;
    /**
     * 异常字段值
     */
    private Object rejectedValue;
}