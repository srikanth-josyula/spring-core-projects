package com.sample.annotations;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Value;

public class MailService {

	@Value("administrator@example.org,administrator1@example.org")
	private String administrator;
	private Set<String> support;
	private HashMap<String, String> development;

	public Set<String> getSupport() {
		return support;
	}

	public void setSupport(Set<String> support) {
		this.support = support;
	}

	public HashMap<String, String> getDevelopment() {
		return development;
	}

	public void setDevelopment(HashMap<String, String> development) {
		this.development = development;
	}

	public void failMail() {
		String[] adminList = administrator.split(",");
		for (String mailID : adminList) {
			System.out.println("Mail is sent to :: " + mailID);
		}
		for (String mailID : support) {
			System.out.println("Mail is sent to :: " + mailID);
		}

		for (Entry<String, String> mailID : development.entrySet()) {
			System.out.println("Mail is sent to :: " + mailID.getValue());
		}
	}

	public void successMail() {
		String[] adminList = administrator.split(",");
		for (String mailID : adminList) {
			System.out.println("Mail is sent to :: " + mailID);
		}
		for (String mailID : support) {
			System.out.println("Mail is sent to :: " + mailID);
		}
	}
}
