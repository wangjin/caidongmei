package com.caidongmei.alumniassociation.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SingletonBeanCreaterUtil {
	private static ApplicationContext ctx = null;
	private static SingletonBeanCreaterUtil instance;
	private SingletonBeanCreaterUtil() {
		ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
	}
	
	public static SingletonBeanCreaterUtil getInstance() {
		if (instance == null) {
			instance = new SingletonBeanCreaterUtil();
		}
		return instance;
	}

	public Object getBean(String name) {

		return ctx.getBean(name);
	}

}
