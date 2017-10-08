package net.samhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created by huangs22 on 2017/9/3.
 */
public class School {
//    @Autowired
//    @Qualifier("personw")
    @Resource(name="personw")
    private Person person;

    @Autowired
    private Teachers teachers;

    public School() {
    }

    public String getPersonName() {
        return person.getName()+teachers.getName();
    }
}
