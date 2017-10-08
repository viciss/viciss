package net.samhouse;

import net.samhouse.impl.CompactDisc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
                Config.class
        );
        MagicBean bean = applicationContext.getBean(MagicBean.class);
        bean.doSomething();

        CompactDisc cd = applicationContext.getBean(CompactDisc.class);
        cd.play();
    }
}
