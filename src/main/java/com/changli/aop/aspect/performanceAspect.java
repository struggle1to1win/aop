package com.changli.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class performanceAspect {
    @Around("repositoryOps()")
    public Object logPerformance(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        String name="-";
        String result="Y";
        try{
            name = pjp.getSignature().toShortString();
            return pjp.proceed();
        }catch (Throwable t){
            result = "N";
            throw t;
        }finally {
            long end =System.currentTimeMillis();
            log.info("{};{};{}ms",name,result,end-start);
        }
    }

    @Pointcut("execution(* com.changli.aop.repository..*(..))")
    private void repositoryOps(){}
}
