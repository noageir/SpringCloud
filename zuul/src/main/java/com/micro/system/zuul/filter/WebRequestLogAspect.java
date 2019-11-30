package com.micro.system.zuul.filter;

import com.micro.system.util.LoggerPoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Noageir
 * Date: 2018-05-11 22:03
 * Project: com.spring.cloud
 * Package: com.micro.system.zuul.filter
 */
@Aspect
@Component
public class WebRequestLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebRequestLogAspect.class);

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
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // ob 为方法的返回值
        Object ob = pjp.proceed();
        logger.info("Time Consuming:{}", (System.currentTimeMillis() - startTime));
        return ob;
    }
}
