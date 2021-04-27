package com.sample.clients;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.autowiring.setter.service.impl.ReportGenerator;


public class SetterAutoWiringClient {
	public static void main(String[] args) {

		String bean = "successReport";
		AbstractApplicationContext context = null;

		try {
			context = new ClassPathXmlApplicationContext("autowire-st-config.xml");
			ReportGenerator reportService = (ReportGenerator) context.getBean(bean);

			reportService.initiateService();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}

	}

}
