package com.sample.autoscanning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.sample.autoscanning.MailService;
import com.sample.autoscanning.service.impl.ReportGenerator;

@Component(value = "successReport")
public class SuccessReportGenerator implements ReportGenerator {
	
	@Autowired
	@Qualifier("mailService")
	private MailService successMail;
	@Value("100")
	private int totalRecords;
	@Value("50") 
	int recordsPerPage;

	public MailService getMailService() {
		return successMail;
	}

	public void setMailService(MailService mailService) {
		this.successMail = mailService;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public void initiateService() {
		displayCount();
		successMail.successMail();
	}

	public String generateReport(int recordsPerPage) {
		return "Generated PDF Report with " + recordsPerPage + " records";
	}

	public void displayCount() {
		System.out.println("Hi, Total No.Of Pages per Record are :: " + recordsPerPage
				+ " and Total No.Of Records are :: " + totalRecords);
	}
}