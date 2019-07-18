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
 * Package:com.micro.system.consumption.config
 */
@Configuration
@EnableTransactionManagement
@Log4j2
public class DataSourceConfig {
//    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource() {
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        log.info("-----------------主库信息已载入-------------------");
        log.info("主数据库信息：{}", masterDataSource.toString());
        return masterDataSource;
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource() {
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        log.info("-----------------从库信息已载入-------------------");
        log.info("从数据库信息：{}", slaveDataSource.toString());
        return slaveDataSource;
    }
}
