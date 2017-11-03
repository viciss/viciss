package net.samhouse;

import org.springframework.stereotype.Component;

@Component
public class C {
    public C() {
        System.out.println("This is hello from C");
    }

    public void doSomething() {
        System.out.println("This is do something from class C!");
    }
}
