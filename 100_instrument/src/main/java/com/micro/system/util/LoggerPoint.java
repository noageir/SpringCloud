package com.micro.system.util;

import com.google.gson.Gson;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


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
        logger.info("***Request****************************");
        logger.info("HTTP METHOD:{}", request.getMethod());
        logger.info("Ip:{}", getIpAddress(request));
        logger.info("Request:{}", request.getRequestURL().toString());
        logger.info("Class Method:{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("Parameter:{}", Arrays.toString(joinPoint.getArgs()));
        logger.info("***Request****************************");
    }

    public static void loggerResponse(Object ret, Class object) {
        Logger logger = LoggerFactory.getLogger(object);
        logger.info("***Response****************************");
        Gson gson = new Gson();
        String result = gson.toJson(ret);
        logger.info("Return Value:{}", result);
        logger.info("***Response****************************");
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
