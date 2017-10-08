package net.samhouse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience2 {
    @Pointcut("execution(* net.samhouse.Concert.perform(..))")
    public void performance() {}

    @Around("performance()")
    public void watchPerformance(ProceedingJoinPoint jp) {
        try {
            System.out.println("Silencing cell phones from " + this.getClass().getSimpleName());
            System.out.println("Taking seats from " + this.getClass().getSimpleName());
            jp.proceed();
            System.out.println("CLAP CLAP CLAP!!! from " + this.getClass().getSimpleName());
        } catch (Throwable e) {
            System.out.println("Demanding a refund from " + this.getClass().getSimpleName());
        }
    }
}
