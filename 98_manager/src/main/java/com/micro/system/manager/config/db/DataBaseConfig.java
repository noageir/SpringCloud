package com.micro.system.manager.config.db;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Noageir
 * Date:2018-05-13 8:47
 * Project:com.spring.cloud
 * Package:com.micro.system.manager.config
 */
@Configuration
@AutoConfigureAfter({DataSourceConfig.class})
public class DataBaseConfig extends MybatisAutoConfiguration {
    @Resource(name = "masterDataSource")
    private DataSource masterDataSource;

    @Resource(name = "slaveDataSource")
    private DataSource slaveDataSource;

    public DataBaseConfig(MybatisProperties properties, ObjectProvider<Interceptor[]> interceptorsProvider, ResourceLoader resourceLoader, ObjectProvider<DatabaseIdProvider> databaseIdProvider, ObjectProvider<List<ConfigurationCustomizer>> configurationCustomizersProvider) {
        super(properties, interceptorsProvider, resourceLoader, databaseIdProvider, configurationCustomizersProvider);
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(roundRobinDataSourceProxy());
    }

    private AbstractRoutingDataSource roundRobinDataSourceProxy() {

        RoutingDataSource proxy = new RoutingDataSource();
        Map<Object, Object> targetDataSource = new HashMap<>(2);

        targetDataSource.put(DataBaseContextHolder.DataBaseType.MASTER, masterDataSource);

        targetDataSource.put(DataBaseContextHolder.DataBaseType.SLAVE, slaveDataSource);
        //默认数据源
        proxy.setDefaultTargetDataSource(masterDataSource);
        //装入两个主从数据源
        proxy.setTargetDataSources(targetDataSource);
        return proxy;

    }
}
