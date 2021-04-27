package com.sample.autowiring.constructor.service;

import com.sample.autowiring.constructor.MailService;
import com.sample.autowiring.constructor.service.impl.ReportGenerator;

public class SuccessReportGenerator implements ReportGenerator {

	private int recordsPerPage;
	private int totalRecords;
	private MailService mailService;

	public SuccessReportGenerator(int recordsPerPage, int totalRecords, MailService mailService) {
		super();
		this.recordsPerPage = recordsPerPage;
		this.totalRecords = totalRecords;
		this.mailService = mailService;
	}


	public void initiateService() {
		displayCount();
		mailService.successMail();

	}

	public String generateReport(int recordsPerPage) {
		return "Generated Success Report with " + recordsPerPage + " records";
	}

	public void displayCount() {
		System.out.println("Hi, Total No.Of Pages per Record are :: " + recordsPerPage
				+ " and Total No.Of Records are :: " + totalRecords);
	}
}
