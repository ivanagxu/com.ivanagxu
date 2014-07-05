package com.ivanagxu.test.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class ProxyJMSConsumer implements MessageListener{
	public ProxyJMSConsumer() {

	}

	private JmsTemplate jmsTemplate;

	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}


//	public void recive() {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
//				new String[] { "classpath:/spring/applicationContext-jms.xml" });
//
//		Destination destination = (Destination) applicationContext
//				.getBean("destination");
//
//		while (true) {
//
//			try {
//				TextMessage txtmsg = (TextMessage) jmsTemplate
//						.receive(destination);
//				if (null != txtmsg) {
//					System.out.println("[DB Proxy] " + txtmsg);
//					System.out.println("[DB Proxy] 收到消息内容为: "
//							+ txtmsg.getText());
//				} else
//					break;
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//	}

	public void onMessage(Message message) {
		try {
			TextMessage txtMsg = (TextMessage)message;
			System.out.println("Received Text Message: " + txtMsg.getText());
			System.out.println("My name is " + txtMsg.getStringProperty("name"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
