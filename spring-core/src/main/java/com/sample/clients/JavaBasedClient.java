package com.sample.clients;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.sample.javabased.config.AppConfig;
import com.sample.javabased.service.impl.ReportGenerator;


public class JavaBasedClient {
	public static void main(String[] args) {

		AbstractApplicationContext context = null;

		try {
			context = new AnnotationConfigApplicationContext(AppConfig.class);
			ReportGenerator srv1 = (ReportGenerator) context.getBean("failReport");
			srv1.initiateService();
			System.out.println("**********************");
			ReportGenerator srv2 = (ReportGenerator) context.getBean("successReport");
			srv2.initiateService();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}

	}

}
