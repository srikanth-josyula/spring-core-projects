package com.sample.dI.setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class MailService {

	private List<String> administrator;
	private Set<String> support;
	private HashMap<String,String> development;

	
	public List<String> getAdministrator() {
		return administrator;
	}


	public void setAdministrator(List<String> administrator) {
		this.administrator = administrator;
	}


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
