package com.moonu.mealbuddy.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LogManager {
    @Pointcut("execution(* com.moonu.mealbuddy.service.*.*(..))")
    public void logBefore(){
        //This method defined for routing
    }

    @Pointcut("execution(* com.moonu.mealbuddy.service.*.*(..))")
    public void logAround(){
        //This method defined for routing
    }
}
