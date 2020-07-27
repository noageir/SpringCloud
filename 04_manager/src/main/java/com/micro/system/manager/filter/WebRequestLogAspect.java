package com.micro.system.manager.filter;

import com.micro.system.util.ArithUtil;
import com.micro.system.util.LoggerPoint;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.manager.filter
 */
@Aspect
@Component
@Log4j2
public class WebRequestLogAspect {

    @Pointcut("execution(public * com.micro.system.*.web..*.*(..))")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        // 记录下请求内容
        LoggerPoint.loggerRequestPoint(request, joinPoint, WebRequestLogAspect.class);
    }

    @AfterReturning(returning = "ret", pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        LoggerPoint.loggerResponse(ret, WebRequestLogAspect.class);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        // ob 为方法的返回值
        Object ob = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis() - startTime;
        double calculateNum = Double.parseDouble(String.valueOf(endTime));
        log.info("Time Consuming (Sec):{}", ArithUtil.div(calculateNum, 1000));
        return ob;
    }
}
