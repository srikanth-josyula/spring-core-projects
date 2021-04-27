package com.sample.clients;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.autowiring.constructor.service.impl.ReportGenerator;

public class ConstructorAutoWiringClient {
	public static void main(String[] args) {

		String bean = "successReport";
		AbstractApplicationContext context = null;
		
		try {
			context = new ClassPathXmlApplicationContext("autowire-con-config.xml");
			ReportGenerator reportService = (ReportGenerator) context.getBean(bean);

			reportService.initiateService();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}

	}

}
