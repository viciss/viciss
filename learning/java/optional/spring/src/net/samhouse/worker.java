package net.samhouse;

/**
 * Created by huangs22 on 2017/9/1.
 */
public class worker implements Person {
    private String name;

    public worker() {

    }

    @Override
    public String getName() {
        return "This is a Worker";
    }
}
