package com.micro.system.manager.config.db;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;


/**
 * @author Noageir
 * Date:2018-05-13 8:48
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.config
 */
@Configuration
@EnableTransactionManagement
@Log4j2
public class DataSourceConfig {
    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.write")
    public DataSource writeDataSource() {
        DataSource writeDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        log.info("--------------------------------------------------------------------------------------");
        log.info("-----------------Database Write Library Information Has Been Loaded-------------------");
        return writeDataSource;
    }

    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "druid.read")
    public DataSource readDataSource() {
        DataSource readDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        log.info("-----------------Database  Read Library Information Has Been Loaded-------------------");
        log.info("--------------------------------------------------------------------------------------");
        return readDataSource;
    }
}
