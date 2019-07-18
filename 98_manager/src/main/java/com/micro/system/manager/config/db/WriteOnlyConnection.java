package com.micro.system.manager.config.db;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Noageir
 * Date:2018-05-13 8:56
 * Project:com.spring.cloud
 * Package:com.micro.system.consumption.config.db
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface WriteOnlyConnection {
}
