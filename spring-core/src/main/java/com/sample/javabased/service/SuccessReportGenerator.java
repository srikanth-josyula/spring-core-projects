package com.sample.javabased.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sample.javabased.MailService;
import com.sample.javabased.service.impl.ReportGenerator;

@Component(value = "successReport")
public class SuccessReportGenerator implements ReportGenerator {
	
	@Autowired
	@Qualifier("mailService")
	private MailService successMail;
	private int totalRecords;
	private int recordsPerPage;

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
		return successMail;
	}

	public void setMailService(MailService mailService) {
		this.successMail = mailService;
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