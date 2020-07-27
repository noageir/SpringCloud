package com.micro.system.zuul.filter;

import com.micro.system.util.CommonException;
import com.micro.system.util.ErrorPoint;
import com.micro.system.util.ReturnJson;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
class GlobalExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req, MethodArgumentNotValidException exception) {
        return ErrorPoint.logErrorInfo(exception, GlobalExceptionHandler.class);
    }

    @ExceptionHandler(value = CommonException.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req, CommonException exception) {
        return ErrorPoint.logCommonErrorInfo(exception, GlobalExceptionHandler.class);
    }

    @ExceptionHandler(value = Exception.class)
    public ReturnJson defaultErrorHandler(HttpServletRequest req, Exception exception) {
        return ErrorPoint.logExceptionInfo(exception, GlobalExceptionHandler.class);
    }
}
