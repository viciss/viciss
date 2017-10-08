package net.samhouse;

import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by huangs22 on 2017/9/1.
 */
public class main {
    public static void main(String[] args) throws Exception {
        try {
            FileSystemXmlApplicationContext ctx = new FileSystemXmlApplicationContext(args);
            School school = ctx.getBean(School.class);
            String name = school.getPersonName();
            System.out.println("The person name is: " + name);
        } catch (Exception e) {

        }
    }
}
