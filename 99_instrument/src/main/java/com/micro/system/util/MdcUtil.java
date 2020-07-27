package com.micro.system.util;

import org.slf4j.MDC;

/**
 * @author Noageir
 * Date:2018-05-06 22:20
 * Project:com.spring.cloud
 * Package:com.micro.system.eureka
 */
public class MdcUtil {
    /**
     * 角色
     */
    public static final String MDC_ROLE_LIST = "roleList";
    /**
     * 用户名
     */
    public static final String MDC_USER_ID = "userId";
    /**
     * 请求事物ID
     */
    public static final String MDC_TRANSACTION_ID = "transactionId";

    /**
     * 获取请求用的角色
     */
    public static String getRoleList() {
        return MDC.get(MDC_ROLE_LIST);
    }

    /**
     * 设置请求用户的角色
     */
    public static void setRoleList(String roleList) {
        MDC.put(MDC_ROLE_LIST, roleList);
    }

    /**
     * 获取请求用户名
     */
    public static String getUserId() {
        return MDC.get(MDC_USER_ID);
    }

    /**
     * 设置请求用户名
     */
    public static void setUserId(String userId) {
        MDC.put(MDC_USER_ID, userId);
    }

    /**
     * 获取请求事物ID
     */
    public static String getTransactionId() {
        return MDC.get(MDC_TRANSACTION_ID);
    }

    /**
     * 设置请求事物ID
     */
    public static void setTransactionId(String transactionId) {
        MDC.put(MDC_TRANSACTION_ID, transactionId);
    }

    /**
     * 生成请求事物ID
     */
    public static String generateTransactionId() {
        return String.valueOf(System.currentTimeMillis() + RandomUtil.generateSafeRandomNum(1000000));
    }
}
