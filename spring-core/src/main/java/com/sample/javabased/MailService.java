package com.sample.javabased;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "mailService")
public class MailService {

	@Value("administrator@example.org,administrator1@example.org")
	private String administrator;
	@Value("support@example.org,support1@example.org")
	private String support;
	@Value("development@example.org,development1@example.org")
	private String development;

	public void failMail() {
		String[] adminList = administrator.split(",");
		for (String mailID : adminList) {
			System.out.println("Mail is sent to :: " + mailID);
		}
		String[] supportList = support.split(",");
		for (String mailID : supportList) {
			System.out.println("Mail is sent to :: " + mailID);
		}

		String[] devList = development.split(",");
		for (String mailID : devList) {
			System.out.println("Mail is sent to :: " + mailID);
		}
	}

	public void successMail() {
		String[] adminList = administrator.split(",");
		for (String mailID : adminList) {
			System.out.println("Mail is sent to :: " + mailID);
		}
		String[] supportList = support.split(",");
		for (String mailID : supportList) {
			System.out.println("Mail is sent to :: " + mailID);
		}
	}
}