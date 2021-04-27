package com.operations.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.operations.dao.PersonDAO;
import com.operations.entities.PersonEntity;
import com.operations.service.PersonService;

@Service("personservice")
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO;

	public PersonDAO getPersonDAO() {
		return personDAO;
	}

	@Autowired
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	public void insertPerson(PersonEntity prs) {
		personDAO.create(prs);
	}

	public int removePerson(int prsId) {
		return personDAO.delete(prsId);
	}

	public List<PersonEntity> getAllPersons() {
		return personDAO.getAll();
	}

	public int getNumberOfPersons() {
		return personDAO.getCount();
	}

	public int updatePerson(int prsId, String prsName) {
		return personDAO.update(prsId, prsName);
	}

	public PersonEntity getPerson(int prsId) {
		return personDAO.get(prsId);
	}

}
