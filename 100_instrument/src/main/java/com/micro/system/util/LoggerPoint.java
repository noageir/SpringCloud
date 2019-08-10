package com.micro.system.util;

import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.TreeMap;


/**
 * @author Noageir
 * Date:2018-05-06 14:07
 * Project:com.spring.cloud
 * Package:com.micro.system.util
 */
public class LoggerPoint {

    private static final String UN_KNOWN = "unknown";

    public static void loggerRequestPoint(HttpServletRequest request, JoinPoint joinPoint, Class object) {
        Logger logger = LoggerFactory.getLogger(object);

        //获取当前登录账户ID
        String userId = ToolsUtils.getUserIdFromReq(request);
        String transactionId = request.getHeader(MdcUtil.MDC_TRANSACTION_ID);
        if (StringUtils.isBlank(transactionId)) {
            transactionId = MdcUtil.generateTransactionId();
        }
        String roleList = request.getHeader(MdcUtil.MDC_ROLE_LIST);
        if (StringUtils.isBlank(roleList)) {
            roleList = "";
        }
        MdcUtil.setUserId(userId);
        MdcUtil.setTransactionId(transactionId);
        MdcUtil.setRoleList(roleList);

        logger.info("--01--Request---------------------LoginUserID:" + userId + "---");
        TreeMap<String, Object> reqMap = new TreeMap<String, Object>();
        reqMap.put("1-Http Method", request.getMethod());
        reqMap.put("2-Client Ip", getIpAddress(request));
        reqMap.put("3-Request", request.getRequestURL().toString());
        reqMap.put("4-Class", joinPoint.getSignature().getDeclaringTypeName());
        reqMap.put("5-RestFul", joinPoint.getSignature().getName());
        reqMap.put("6-Parameter", Arrays.toString(joinPoint.getArgs()));
        logger.info("Request Info:{}", reqMap.toString());
    }

    public static void loggerResponse(Object ret, Class object) {
        Logger logger = LoggerFactory.getLogger(object);
        logger.info("--02--Response---------------------");
        Gson gson = new Gson();
        String result = gson.toJson(ret);
        logger.info("Return Value:{}", result);
    }

    private static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || UN_KNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        int port = request.getRemotePort();
        return ip + ":" + port;
    }

}
