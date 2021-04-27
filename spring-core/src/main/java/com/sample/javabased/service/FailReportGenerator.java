package com.sample.javabased.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sample.javabased.MailService;
import com.sample.javabased.service.impl.ReportGenerator;

@Component(value = "failReport")
public class FailReportGenerator implements ReportGenerator {

	@Autowired
	@Qualifier("mailService")
	private MailService failMail;
	private int recordsPerPage;
	private int totalRecords;

	public FailReportGenerator(int recordsPerPage, int totalRecords, MailService mailService) {
		this.recordsPerPage = recordsPerPage;
		this.totalRecords = totalRecords;
		this.failMail = mailService;
	}

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
