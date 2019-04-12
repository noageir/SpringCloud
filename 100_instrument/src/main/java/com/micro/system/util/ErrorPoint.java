package com.micro.system.util;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Noageir
 * Date: 2018-05-20
 * Project: com.springcloud.system.util
 * Package: com.springcloud.system.util
 */
public class ErrorPoint {
    private static final int TO_INDEX = 5;

    private static final int STACK_TRACE_MAX_LEN = 5000;


    public static ReturnJson logErrorInfo(MethodArgumentNotValidException exception, Class object) {
        Logger logger = LoggerFactory.getLogger(object);
        //输出错误详细信息
        logger.error(exception.getMessage(), exception);
        //按需重新封装需要返回的错误信息
        List<ArgumentInvalidResult> invalidArguments = new ArrayList<ArgumentInvalidResult>();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<FieldError> fieldErrorList;
        //显示前五个错误
        if (fieldErrors.size() > TO_INDEX) {
            fieldErrorList = fieldErrors.subList(0, TO_INDEX);
        } else {
            fieldErrorList = fieldErrors;
        }
        for (FieldError error : fieldErrorList) {
            ArgumentInvalidResult invalidArgument = new ArgumentInvalidResult();
            invalidArgument.setErrorMessage(error.getDefaultMessage());
            invalidArgument.setFieldCode(error.getField());
            invalidArgument.setRejectedValue(error.getRejectedValue());
            invalidArgument.setExceptionName(exception.getClass().getSimpleName());
            invalidArguments.add(invalidArgument);
            if (logger.isWarnEnabled()) {
                logger.warn("错误信息：{}", error.toString());
            }
        }
        return ReturnJson.json(CommConstant.ARGUMENT_INVALID, invalidArguments);
    }

    public static ReturnJson logCommonErrorInfo(CommonException exception, Class object) {
        Logger logger = LoggerFactory.getLogger(object);
        ResponseCode responseCode = exception.getResponseCode();
        if (responseCode != null) {
            logger.error(responseCode.toString());
            return ReturnJson.json(responseCode);
        }
        //输出错误详细信息
        logger.error(exception.getMessage(), exception);
        //解析原错误信息，封装后返回
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(exception.getMessage());
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        String stackTrace = ExceptionUtils.getFullStackTrace(exception);
        if (StringUtils.length(stackTrace) > STACK_TRACE_MAX_LEN) {
            stackTrace = StringUtils.substring(stackTrace, 0, STACK_TRACE_MAX_LEN);
        }
        commonResult.setStackTrace(stackTrace);
        return ReturnJson.fail(commonResult);
    }

    public static ReturnJson logExceptionInfo(Exception exception, Class object) {
        //输出错误详细信息
        Logger logger = LoggerFactory.getLogger(object);
        logger.error(exception.getMessage(), exception);
        //解析原错误信息，封装后返回
        CommonResult commonResult = new CommonResult();
        commonResult.setErrorMessage(String.valueOf(exception.getCause()));
        commonResult.setExceptionName(exception.getClass().getSimpleName());
        return ReturnJson.fail(commonResult);
    }
}
