package com.micro.system.manager.batch.impl;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseDAO {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    void batchInsert(String statement, List parameterList) {
        if (parameterList == null || parameterList.size() == 0) {
            return;
        }
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            for (Object aParameterList : parameterList) {
                batchSqlSession.insert(statement, aParameterList);
            }
            batchSqlSession.commit();
            //清理缓存，防止溢出
            batchSqlSession.clearCache();
        } catch (Exception e) {
            logger.error("batch insert error", e);
            if (batchSqlSession != null) {
                batchSqlSession.rollback();
            }
            throw e;
        } finally {
            if (batchSqlSession != null) {
                batchSqlSession.close();
            }
        }
    }

    void batchUpdate(final String statement, final List parameterList) {
        if (parameterList == null || parameterList.size() == 0) {
            return;
        }
        SqlSession batchSqlSession = null;
        try {
            batchSqlSession = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
            for (Object aParameterList : parameterList) {
                batchSqlSession.update(statement, aParameterList);
            }
            batchSqlSession.commit();
            //清理缓存，防止溢出
            batchSqlSession.clearCache();
        } catch (Exception e) {
            logger.error("batch update error", e);
            if (batchSqlSession != null) {
                batchSqlSession.rollback();
            }
        } finally {
            if (batchSqlSession != null) {
                batchSqlSession.close();
            }
        }
    }

}
