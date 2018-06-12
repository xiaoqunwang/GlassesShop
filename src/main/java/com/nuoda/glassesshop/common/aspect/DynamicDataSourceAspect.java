package com.nuoda.glassesshop.common.aspect;

import com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno;
import com.nuoda.glassesshop.common.utils.DataSourceContextHolder;
import com.nuoda.glassesshop.eumn.DataSourceEnum;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class DynamicDataSourceAspect {

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Pointcut("@annotation(com.nuoda.glassesshop.common.annotation.DataSourceTypeAnno)")
//    public void dataSourcePointcut() {
//    }

    @Around("@annotation(dataSourceTypeAnno)")
    public Object doAround(ProceedingJoinPoint pjp,DataSourceTypeAnno dataSourceTypeAnno) {
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        Method method = methodSignature.getMethod();
//        DataSourceTypeAnno typeAnno = method.getAnnotation(DataSourceTypeAnno.class);
        DataSourceEnum sourceEnum = dataSourceTypeAnno.value();


        if (sourceEnum == DataSourceEnum.master) {
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.master);
            logger.info("切换到数据源master");
        } else if (sourceEnum == DataSourceEnum.slaver) {
            DataSourceContextHolder.setDataSourceType(DataSourceEnum.slaver);
            logger.info("切换到数据源slaver");
        }

        Object result = null;
        try {
            System.out.println("动态数据源"+sourceEnum.toString());
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            //最后切回默认数据源master
            DataSourceContextHolder.resetDataSourceType();
        }

        return result;
    }

    @Around("execution(* com.nuoda.glassesshop.provider.controller.TestController.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) {
//        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
//        Method method = methodSignature.getMethod();
//        DataSourceTypeAnno typeAnno = method.getAnnotation(DataSourceTypeAnno.class);

        Object result = null;
        try {
            logger.info("测试Aspect");
            result = pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {

            DataSourceContextHolder.resetDataSourceType();
        }

        return result;
    }

}