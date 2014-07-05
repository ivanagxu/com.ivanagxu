<%@ page import="com.ivanagxu.test.jms.*"%>
<%@ page import="org.springframework.jms.core.*"%>
<%@ page import="javax.jms.*"%>
<%
	JmsTemplate template = (JmsTemplate) SpringContextHolder
			.getInstence().getBeanFactory().getBean("jmsTemplate");

	Destination destination = (Destination) SpringContextHolder
			.getInstence().getBeanFactory().getBean("destination");

	template.send(destination, new MessageCreator() {
		public Message createMessage(Session session)
				throws JMSException {
			Message msg = session
					.createTextMessage("Send message: Hello ActiveMQ");
			msg.setStringProperty("name", "Ivan");
			return msg;
		}
	});
	System.out.println("Send successfully");
%>

<html>
<title>Message Sender</title>
<body>
<h2>Message was sent</h2>
</body>
</html>