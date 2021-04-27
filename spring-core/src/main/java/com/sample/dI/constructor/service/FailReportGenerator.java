package com.sample.dI.constructor.service;

import com.sample.dI.constructor.MailService;
import com.sample.dI.constructor.service.impl.ReportGenerator;

public class FailReportGenerator implements ReportGenerator {

	private int recordsPerPage;
	private int totalRecords;
	private MailService mailService;

	public FailReportGenerator(int recordsPerPage, int totalRecords, MailService mailService) {
		this.recordsPerPage = recordsPerPage;
		this.totalRecords = totalRecords;
		this.mailService = mailService;
	}

	public void initiateService() {
		displayCount();
		mailService.failMail();
	}

	public String generateReport(int recordsPerPage) {
		return "Generated Failure Report  with " + recordsPerPage + " records";
	}

	public void displayCount() {
		System.out.println("Hi, Total No.Of Pages per Record are :: " + recordsPerPage
				+ " and Total No.Of Records are :: " + totalRecords);
	}

}
