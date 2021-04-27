package com.sample.clients;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sample.dI.setter.service.impl.ReportGenerator;

public class SetterDIClient {
	public static void main(String[] args) {

		String bean = "failReport";
		AbstractApplicationContext context = null;

		try {
			context = new ClassPathXmlApplicationContext("st-config.xml");
			ReportGenerator reportService = (ReportGenerator) context.getBean(bean);

			reportService.initiateService();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			context.close();
		}

	}

}
