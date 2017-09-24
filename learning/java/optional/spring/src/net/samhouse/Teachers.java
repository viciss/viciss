package net.samhouse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huangs22 on 2017/9/3.
 */
public class Teachers {

    @Autowired
    private Person teacher;

    public Teachers() {
    }

    public String getName() {
        return teacher.getName();
    }
}
