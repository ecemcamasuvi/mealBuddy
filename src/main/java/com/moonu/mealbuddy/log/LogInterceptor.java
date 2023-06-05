package com.moonu.mealbuddy.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;

@Service
@Aspect
public class LogInterceptor {

    private static final Logger LOG = Logger.getLogger(LogInterceptor.class.getName());

    @Before(value = "com.moonu.mealbuddy.log.LogManager.logBefore()"
            + "&& @annotation(com.moonu.mealbuddy.log.Logger)"
            + "&& @annotation(loggable)", argNames = "loggable")
    public void logBefore(JoinPoint joinPoint, com.moonu.mealbuddy.log.Logger loggable) throws InterruptedException{

        var startTime = System.currentTimeMillis();
        // random delay
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(10, 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

        var processTime = System.currentTimeMillis() - startTime;
        StringBuilder sb = new StringBuilder();
        sb.append("It took " + processTime + " ms to generate this message.");
        sb.append(loggable.value());
        String message = sb.toString();
        LOG.log(Level.INFO,message);

    }


    @Around(value = "com.moonu.mealbuddy.log.LogManager.logAround()"
            + "&& @annotation(com.moonu.mealbuddy.log.Logger)"
            + "&& @annotation(loggable)", argNames = "loggable")
    public void logAround(ProceedingJoinPoint joinPoint, com.moonu.mealbuddy.log.Logger loggable) throws Throwable{
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        joinPoint.proceed();

        stopWatch.stop();
        var processTime = stopWatch.getTotalTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("It took " + processTime + " ms to generate this message.");
        sb.append(joinPoint.getSignature().getName());
        String message = sb.toString();
        LOG.log(Level.INFO,message);
    }

}
