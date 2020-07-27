package com.micro.system.manager.config.db;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

/**
 * @author Noageir
 * Date:2018-05-13 8:57
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.config.db
 */
@Aspect
@Component
@Log4j2
public class WriteOnlyConnectionInterceptor implements Ordered {

    @Around("@annotation(writeOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, WriteOnlyConnection writeOnlyConnection) throws Throwable {
        try {
            log.info("---------------The Database Is Set To The Write Library---------------");
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.WRITE);
            return proceedingJoinPoint.proceed();
        } finally {
            DataBaseContextHolder.clearDataBaseType();
            log.info("---------------Clear Database Settings---------------");
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
