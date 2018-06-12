package com.nuoda.glassesshop.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@Configuration
@Aspect
public aspect TestAspect {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());


    @Around("execution(* com.nuoda.glassesshop.provider.controller.UserRegisterController.*.*(..))")
    public Object doAround(ProceedingJoinPoint pjp) {

        try {
            logger.info("hahahahhahahah");
            System.err.println ("切面doaspect执行了");
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;



    }



}
