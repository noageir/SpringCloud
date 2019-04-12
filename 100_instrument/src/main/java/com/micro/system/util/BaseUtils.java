package com.micro.system.util;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Noageir
 * Date:2018-05-13 16:23
 * Project:com.spring.cloud
 * Package:com.micro.system.util
 */
public class BaseUtils {
    /**
     * base64字符串转byte[]
     *
     * @param base64Str 入参
     * @return 返参
     */
    public static byte[] base64String2ByteFun(String base64Str) {
        return Base64.decodeBase64(base64Str);
    }

    /**
     * byte[]转base64
     *
     * @param b 入参
     * @return 返参
     */
    public static String byte2Base64StringFun(byte[] b) {
        return Base64.encodeBase64String(b);
    }
}
