package com.operations.service;

import java.util.List;

import com.operations.entities.PersonEntity;

public interface PersonService {
	public void insertPerson(PersonEntity prs);
	public int removePerson(int prsId);
	public List<PersonEntity> getAllPersons();
	public int getNumberOfPersons();
	public int updatePerson(int prsId, String prsName);
	public PersonEntity getPerson(int prsId);
}
