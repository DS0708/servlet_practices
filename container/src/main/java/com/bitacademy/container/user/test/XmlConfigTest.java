package com.bitacademy.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigTest {

	public static void main(String[] args) {
		//1. XML Auto Configuration(Annotation Configuration)
		testXMLAutoConfiguration();
		
		//2. XML Explicit Configuration(Bean Configuration)
		// testXMLExplicitConfiguration();
	}

	private static void testXMLAutoConfiguration() {
		ApplicationContext ac=
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
	}

}
