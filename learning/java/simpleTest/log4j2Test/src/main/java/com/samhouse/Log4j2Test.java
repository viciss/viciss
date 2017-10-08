package com.samhouse;

import org.apache.logging.log4j.core.config.Configurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Log4j2Test {
    // generally, log4j2 should be used as following, but for demo purpose,
    // I just commented the following line and initialize log4j2 in main function
    // final static Logger logger = LogManager.getLogger(Log4j2Test.class);

    private final static String PID;
    static {
        // get current process id
        RuntimeMXBean rt = ManagementFactory.getRuntimeMXBean();
        PID = rt.getName().replaceAll("@.*", "");
    }

    public static void main(String[] args) {
        // Use configurator to specify the location of log4j2 configuration file
        Configurator.initialize("log4j2", "classpath:log4j2.xml");
        Logger logger = LoggerFactory.getLogger(Log4j2Test.class);
//        Logger logger = LogManager.getLogger(Log4j2Test.class);

        // use thread context to pass the self defined PID to PatternLayout
//        ThreadContext.put("PID", PID);
        MDC.put("PID", PID);

        // test for using {} in logger.info
        int id = 10;
        logger.info("Main started, and id is {}", id);

        // test for output exception
        Log4j2Test test = new Log4j2Test();
        try {
            logger.debug("Before divide executed!");
            test.divide();
        }
        catch (ArithmeticException e) {
            logger.error("Divided by 0 error!", e);
        }

        logger.info("Main exits!");
        MDC.clear();
    }

    private void divide() {
        int i = 10/0;
    }
}
