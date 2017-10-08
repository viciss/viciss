package net.samhouse;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Audience {
    @Before("execution(* *.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones from " + this.getClass().getSimpleName());
    }

    @Before("execution(* *.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats from " + this.getClass().getSimpleName());
    }

    @AfterReturning("execution(* *.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!! from " + this.getClass().getSimpleName());
    }

    @AfterThrowing("execution(* *.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund from " + this.getClass().getSimpleName());
    }
}
