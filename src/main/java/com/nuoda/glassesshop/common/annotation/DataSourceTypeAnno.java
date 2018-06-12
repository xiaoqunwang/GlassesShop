package com.nuoda.glassesshop.common.annotation;

import com.nuoda.glassesshop.eumn.DataSourceEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME) // 在运行时可见
@Target({ElementType.METHOD}) // 注解可以用在方法上
public @interface DataSourceTypeAnno {
    DataSourceEnum value() default DataSourceEnum.master;
}