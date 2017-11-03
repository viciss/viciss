package net.samhouse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(
                        net.samhouse.Config.class
                );
        B b = applicationContext.getBean(B.class);
        b.doSomething();
    }
}
