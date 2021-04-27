package com.sample.annotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sample.annotations.MailService;
import com.sample.annotations.service.impl.ReportGenerator;

public class FailReportGenerator implements ReportGenerator {

	// @Autowired // Autowired on property
	private MailService failMail;

	@Value("100")
	private int recordsPerPage;
	private int totalRecords;

	public FailReportGenerator() {

	}

	// @Autowired // Autowired on constructor (if using this then the injestion is
	// done as constructor)
	public FailReportGenerator(MailService mailService) {
		System.out.println("Parameterized Constructor");
		this.failMail = mailService;
	}

	public MailService getMailService() {
		return failMail;
	}

	@Autowired // Autowired on Setter
	public void setMailService(MailService mailService) {
		System.out.println("Setter method of master property");
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
