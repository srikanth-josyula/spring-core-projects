package com.sample.javabased.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.sample.javabased.MailService;
import com.sample.javabased.service.FailReportGenerator;
import com.sample.javabased.service.SuccessReportGenerator;
import com.sample.javabased.service.impl.ReportGenerator;

@Configuration
@ComponentScan("com.sample.javabased")
public class AppConfig {

	@Bean
	public MailService failMail() {
		return new MailService();

	}

	@Bean 
	public MailService successMail() {
		return new MailService();

	}

	@Bean //Using Constructor Injection
	public ReportGenerator failReport() {
		ReportGenerator failReport = new FailReportGenerator(100,150,failMail());
		return failReport;

	}

	@Bean(name = "successReport") //Using setter injection
	public ReportGenerator report() {
		SuccessReportGenerator report = new SuccessReportGenerator();
		report.setMailService(successMail());
		report.setRecordsPerPage(50);
		report.setTotalRecords(120);
		return report;
	}
}
