package net.samhouse;

import net.samhouse.impl.Knight;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.URL;
import java.net.URLClassLoader;

public class KnightMain {
    public static void main(String[] args) throws Exception {
        printCurrentCP();

        // used when using xml configuration
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/knights.xml");

        // used when using annotation configuration
//        ApplicationContext context = new AnnotationConfigApplicationContext(
//                net.samhouse.config.KnightConfig.class
//        );
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }

    public static void printCurrentCP() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader)classLoader).getURLs();
        for (URL url: urls) {
            System.out.println(url.getFile());
        }
    }
}
