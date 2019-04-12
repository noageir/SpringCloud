package com.micro.system.util;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.util
 */
public class CommonException extends RuntimeException {
    private ResponseCode responseCode;

    /**
     * Source Throwable, message, status code and info about the cause
     */
    public CommonException(Throwable throwable, ResponseCode responseCode) {
        super(responseCode.getMessage(), throwable);
        this.responseCode = responseCode;
    }

    /**
     * error message, status code and info about the cause
     */
    public CommonException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.responseCode = responseCode;
    }

    public CommonException(String code, String mesg) {
        super(mesg);
        this.responseCode = new ResponseCode(code, mesg);
    }

    public CommonException(Throwable throwable, String msg) {
        super(msg, throwable);
    }

    ResponseCode getResponseCode() {
        return responseCode;
    }
}
