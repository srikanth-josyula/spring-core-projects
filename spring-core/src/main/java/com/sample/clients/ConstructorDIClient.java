package com.sample.clients;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.sample.dI.constructor.service.FailReportGenerator;
import com.sample.dI.constructor.service.SuccessReportGenerator;
import com.sample.dI.constructor.service.impl.ReportGenerator;

public class ConstructorDIClient {
	public static void main(String[] args) {

		AbstractApplicationContext context = null;
		ApplicationContext context1 = null;
		FileSystemXmlApplicationContext context2 = null;
		try {

			/** ApplicationContext Container **/
			// If its classpath then, code checks in complete classpath for the file
			context = new ClassPathXmlApplicationContext("di-config.xml");
			context1 = new ClassPathXmlApplicationContext("di-config.xml");

			// If its Filesystem then, code checks in provided exact location for the file
			context2 = new FileSystemXmlApplicationContext("src/main/resources/di-config.xml");

			ReportGenerator reportgen = (ReportGenerator) context.getBean("failReport");
			ReportGenerator reportgen1 = (ReportGenerator) context1.getBean(FailReportGenerator.class);
			ReportGenerator reportgen2 = context2.getBean("successReport", SuccessReportGenerator.class);

			reportgen.initiateService();
			reportgen1.initiateService();
			reportgen2.initiateService();

			System.out.println("HashCode :: " + reportgen1.hashCode());
			System.out.println("HashCode :: " + reportgen2.hashCode());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			context.close();
			((ClassPathXmlApplicationContext) context1).close();
			context2.close();
		}

		/** Bean Factory Container **/

		BeanFactory factory = null;
		BeanFactory factory1 = null;
		try {
			Resource resource = new ClassPathResource("di-config.xml");
			FileSystemResource resource1 = new FileSystemResource("src/main/resources/di-config.xml");

			factory = new XmlBeanFactory(resource);
			factory1 = new XmlBeanFactory(resource1);

			/*ReportGenerator Breportgen = (ReportGenerator) factory.getBean("failReport");
			ReportGenerator Breportgen1 = (ReportGenerator) factory.getBean("successReport");

			Breportgen.initiateService();
			Breportgen1.initiateService();*/

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			((ConfigurableBeanFactory) factory).destroySingletons();
			((ConfigurableBeanFactory) factory1).destroySingletons();
		}

	}

}
