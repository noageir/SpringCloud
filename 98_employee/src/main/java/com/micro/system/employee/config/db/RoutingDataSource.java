package com.micro.system.employee.config.db;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author Noageir
 * Date:2018-05-13 8:51
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.config
 */
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataBaseContextHolder.getDataBaseType();
    }
}
