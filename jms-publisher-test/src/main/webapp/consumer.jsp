<%@ page import="com.ivanagxu.test.jms.*"%>
<%
	ProxyJMSConsumer proxyJMSConsumer = (ProxyJMSConsumer) SpringContextHolder
			.getInstence().getBeanFactory().getBean("messageReceiver");
	System.out.println("Init Consumer success");
%>

<html>
<title>Consumer</title>
<body>
<h2>Consumer Ready</h2>
</body>
</html>