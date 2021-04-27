package com.operations.entities;

public class PersonEntity {

	private int personId;
	private String personName;
	private String email;

	public PersonEntity() {
		super();
	}

	public PersonEntity(int personId, String personName, String email) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.email = email;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "PersonEntity [personId=" + personId + ", personName=" + personName + ", email=" + email + "]";
	}

}
