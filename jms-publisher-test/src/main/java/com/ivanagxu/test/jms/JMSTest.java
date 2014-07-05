package com.ivanagxu.test.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JMSTest {
	public static void main(String[] args) {  
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(  
                new String[] { "classpath:applicationContext.xml" });  
          
        ProxyJMSConsumer proxyJMSConsumer = (ProxyJMSConsumer) applicationContext  
                .getBean("messageReceiver");  
          
        System.out.println("初始化消息消费者");  
    }  
}
