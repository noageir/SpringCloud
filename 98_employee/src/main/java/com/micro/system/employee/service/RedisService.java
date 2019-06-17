package com.micro.system.employee.service;


import java.util.Collection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author Noageir
 * Date:2018-05-11 23:14
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.service
 */
public interface RedisService {
    /**
     * 删除缓存数据
     *
     * @param key 指定key
     */
    void removeKey(String key);

    /**
     * 批量删除缓存数据，使用List or Set提交
     *
     * @param keys 指定keys
     */
    void removeKeys(Collection<String> keys);

    /***
     * 设置缓存带有超时设定的
     *
     * @param commCodeKey key值
     * @param s           value值
     * @param timeAlive   生存时间
     * @param var5        时间的单位
     */
    void setValueForString(String commCodeKey, String s, long timeAlive, TimeUnit var5);

    String getValueForString(String commCodeKey);

    /**
     * 存放缓存
     *
     * @param commCodeKey key值
     * @param map         value值
     * @param timeAlive   生存时间
     * @param var5        时间的单位
     */
    void setValueForMap(String commCodeKey, Map map, long timeAlive, TimeUnit var5);

    Map getValueForMap(String commCodeKey);
}