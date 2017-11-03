package net.samhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;

    @Autowired
    private AutowireCapableBeanFactory beanFactory;

    public B() {
        System.out.println("This is class B!");
    }

    public void doSomething() {
        a = new A();
        beanFactory.autowireBean(a);
        System.out.println("Hello from do something of B!");
        a.doSomething();
    }
}
