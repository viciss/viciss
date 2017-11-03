package net.samhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {

    @Autowired
    private C c;

    public A() {
        System.out.println("This is class A!");
    }

    public void doSomething() {
        System.out.println("This is do something from A!");
        c.doSomething();
    }
}
