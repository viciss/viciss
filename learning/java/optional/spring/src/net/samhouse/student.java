package net.samhouse;

import org.springframework.context.annotation.Primary;

/**
 * Created by huangs22 on 2017/9/1.
 */
public class student implements Person {
    private String name;

    public student() {
    }

    @Override
    public String getName() {
        return "This is a student!";
    }
}
