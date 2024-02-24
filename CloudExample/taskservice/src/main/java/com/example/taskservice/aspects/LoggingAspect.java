package com.example.taskservice.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class LoggingAspect {
    /**
     * Аспект, который после выполнения методов TaskService, помеченных аннотацией @TrackUserAction,
     * делает запись в терминал о выполненном методе, его аргументах и времени его выполнения
     * @param joinPoint
     */

    @After(value = "@annotation(TrackUserAction)")
    public void loggingMethod(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("At "
                +localDateTime
                +" a request was made with the method: "
                + signature.getMethod().getName());

        System.out.println("Values of method arguments:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> System.out.println("argument value: " + o.toString()));
    }
}
