package com.sample.annotations.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sample.annotations.MailService;
import com.sample.annotations.service.impl.ReportGenerator;

public class SuccessReportGenerator implements ReportGenerator {
	
	@Autowired //Autowired on property
	private MailService successMail;
	@Value("100")
	private int totalRecords;
	private int recordsPerPage;

	public SuccessReportGenerator() {

	}

	//@Autowired // Autowired on constructor (if using this injestion is done as constructor)
	public SuccessReportGenerator(MailService mailService) {
		System.out.println("Parameterized Constructor");
		this.successMail = mailService;
	}

	public MailService getMailService() {
		return successMail;
	}

	// @Autowired // Autowired on Setter
	public void setMailService(MailService mailService) {
		System.out.println("Setter method of master property");
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