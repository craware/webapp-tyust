package com.tyust.dat.netty;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		try {
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext( new String[] { "spring-context.xml" });
			context.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
