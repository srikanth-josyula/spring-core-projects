package com.sample.autowiring.setter.service;

import com.sample.autowiring.setter.MailService;
import com.sample.autowiring.setter.service.impl.ReportGenerator;

public class SuccessReportGenerator implements ReportGenerator {

	private int recordsPerPage;
	private int totalRecords;
	private MailService successMail; // to match the bean name we need to provide as in the bean name if we use byName

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

	public MailService getsuccessMail() {
		return successMail;
	}

	public void setsuccessMail(MailService successMail) {
		this.successMail = successMail;
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
