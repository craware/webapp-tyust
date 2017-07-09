package com.tyust.dat.listener;

import org.springframework.beans.BeansException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * 
 * <br>类 名: ApplicationFactory 
 * <br>描 述: 描述类完成的主要功能
 */
public class ApplicationFactory implements ApplicationContextAware {
	private static ApplicationContext ctx = null;

	/**
	 * 获取Spring配置环境
	 * @return ApplicationContext
	 */
	public static ApplicationContext getContext() {
		if (ctx == null) {
			ctx = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		}
		return ctx;
	}
	
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		ctx = context;
	}
}
