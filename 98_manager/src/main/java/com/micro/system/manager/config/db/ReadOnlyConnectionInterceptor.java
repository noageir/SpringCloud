package com.micro.system.manager.config.db;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Noageir
 * Date:2018-05-13 8:57
 * Project:com.spring.cloud
 * Package:com.micro.system.consumption.config.db
 */
@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {
    private static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        try {
            logger.info("---------------设置为从库---------------");
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            return proceedingJoinPoint.proceed();
        } finally {
            DataBaseContextHolder.clearDataBaseType();
            logger.info("---------------清空数据库设置---------------");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
