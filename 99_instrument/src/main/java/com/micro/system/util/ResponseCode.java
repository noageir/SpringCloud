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
public class ResponseCode implements Serializable {
    private String code;

    private String message;

    public ResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
