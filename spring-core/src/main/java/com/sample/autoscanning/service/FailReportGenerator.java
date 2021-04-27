package com.sample.autoscanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sample.autoscanning.MailService;
import com.sample.autoscanning.service.impl.ReportGenerator;


@Component(value = "failReport")
public class FailReportGenerator implements ReportGenerator {

	@Autowired
	@Qualifier("mailService")
	private MailService failMail;

	@Value("100")
	private int recordsPerPage;
	@Value("50")
	private int totalRecords;

	public MailService getMailService() {
		return failMail;
	}

	public void setMailService(MailService mailService) {
		this.failMail = mailService;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public void initiateService() {
		displayCount();
		failMail.failMail();
	}

	public String generateReport(int recordsPerPage) {
		return "Generated PDF Report with " + recordsPerPage + " records";
	}

	public void displayCount() {
		System.out.println("Hi, Total No.Of Pages per Record are :: " + recordsPerPage
				+ " and Total No.Of Records are :: " + totalRecords);
	}

}
