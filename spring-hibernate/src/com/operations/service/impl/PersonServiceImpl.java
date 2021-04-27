package com.operations.service.impl;

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

}
