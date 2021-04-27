package com.sample.dI.setter.service;

import com.sample.dI.setter.MailService;
import com.sample.dI.setter.service.impl.ReportGenerator;

public class FailReportGenerator implements ReportGenerator {

	private int recordsPerPage;
	private int totalRecords;
	private MailService mailService;

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
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
