package com.demo.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcDemo3 {

    private static Logger logger = LoggerFactory.getLogger(JdbcDemo3.class);

    private static void getLocalip() {
        try {
            System.out.println("服务暴露的ip: "
                    + java.net.InetAddress.getLocalHost().getHostAddress());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        getLocalip();
        logger.info("开始启动asset");

        ClassPathXmlApplicationContext
                context = new ClassPathXmlApplicationContext(
                "classpath:applicationContext.xml");
        context.start();

        synchronized (JdbcDemo3.class) {
            while (true) {
                try {
                    JdbcDemo3.class.wait();
                } catch (Throwable e) {
                }
            }
        }
    }
}
