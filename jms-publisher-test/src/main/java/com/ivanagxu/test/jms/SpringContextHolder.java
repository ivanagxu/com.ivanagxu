package com.ivanagxu.test.jms;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextHolder {
	private static SpringContextHolder instance = null;
	private static Object lockObj = new Object();
	
	private ApplicationContext context = null;
	
	private SpringContextHolder()
	{
		context = new 
				ClassPathXmlApplicationContext( new String[] {"applicationContext.xml"} ); 
	}
	
	public static SpringContextHolder getInstence()
	{
		synchronized(lockObj)
		{
			if(instance == null)
			{
				instance = new SpringContextHolder();
			}
			
			return instance;
		}
	}
	
	public BeanFactory getBeanFactory()
	{
		return context;
	}
}