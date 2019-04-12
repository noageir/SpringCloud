package com.micro.system.employee.config.db;

/**
 * @author Noageir
 * Date:2018-05-13 8:52
 * Project:com.spring.cloud
 * Package:com.micro.system.employee.config
 */
class DataBaseContextHolder {

    private static final ThreadLocal<DataBaseType> CONTEXT_HOLDER = new ThreadLocal<>();

    static DataBaseType getDataBaseType() {
        return CONTEXT_HOLDER.get() == null ? DataBaseType.MASTER : CONTEXT_HOLDER.get();
    }

    static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        CONTEXT_HOLDER.set(dataBaseType);
    }

    static void clearDataBaseType() {
        CONTEXT_HOLDER.remove();
    }

    public enum DataBaseType {
        /**
         * MASTER 主库
         * SLAVE 从库
         */
        MASTER, SLAVE
    }
}
