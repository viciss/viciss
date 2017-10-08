package net.samhouse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                Config.class
        );
        // use jdk proxy to weave the interception,
        // so, only the interface can be used
        Performance concertp = applicationContext.getBean(Performance.class);
        concertp.perform();
        ((Encoreable) concertp).performanceEncore();

        System.out.println("-----------This is break line-----------");
        // only when set @EnableAspectJAutoProxy(proxyTargetClass = true)
        // then following code will run successfully, otherwise it will fail,
        // because it is use cglib to weave the interception
        Concert concert = applicationContext.getBean(Concert.class);
        concert.perform();
        applicationContext.close();
    }
}
