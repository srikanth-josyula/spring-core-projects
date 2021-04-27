package com.sample.dI.constructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MailService {

	private List<String> administrator;
	private Set<String> support;
	private HashMap<String,String> development;

	public MailService(List<String> administrator, Set<String> support, HashMap<String,String> development) {
		this.administrator = administrator;
		this.support = support;
		this.development = development;
	}

	public MailService(List<String> administrator, Set<String> support) {
		this.administrator = administrator;
		this.support = support;
	}
	
	public void failMail() {
		for(String mailID : administrator) {
			System.out.println("Mail is sent to :: "+mailID);
		}
		for(String mailID : support) {
			System.out.println("Mail is sent to :: "+mailID);
		}
		
		for(Entry<String, String> mailID : development.entrySet()) {
			System.out.println("Mail is sent to :: "+mailID.getValue());
		}
	}
	
	public void successMail() {
		for(String mailID : administrator) {
			System.out.println("Mail is sent to :: "+mailID);
		}
		for(String mailID : support) {
			System.out.println("Mail is sent to :: "+mailID);
		}
	}
}
