package com.springboot.glassesshop.common.utils;

import com.springboot.glassesshop.eumn.DataSourceEnum;

public class DataSourceContextHolder {
    private static final ThreadLocal<DataSourceEnum> CONTEXT_HOLDER = new ThreadLocal<DataSourceEnum>() {

        //默认是master
        @Override
        protected DataSourceEnum initialValue() {
            return DataSourceEnum.master;
        }
    };

    //设置数据源
    public static void setDataSourceType(DataSourceEnum type) {
        CONTEXT_HOLDER.set(type);
    }

    //获取数据源
    public static DataSourceEnum getDataSourceType() {
        return CONTEXT_HOLDER.get();
    }

    //重置数据源（默认master）
    public static void resetDataSourceType() {
        CONTEXT_HOLDER.set(DataSourceEnum.master);
    }
}
