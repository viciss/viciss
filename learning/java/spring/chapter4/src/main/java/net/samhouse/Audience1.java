package net.samhouse;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience1 {
    @Pointcut("execution(* *.perform(..))")
    public void performance() {
    }

    @Before("performance()")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones from " + this.getClass().getSimpleName());
    }

    @Before("performance()")
    public void takeSeats() {
        System.out.println("Taking seats from " + this.getClass().getSimpleName());
    }

    @AfterReturning("performance()")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!! from " + this.getClass().getSimpleName());
    }

    @AfterThrowing("performance()")
    public void demandRefund() {
        System.out.println("Demanding a refund from " + this.getClass().getSimpleName());
    }
}
