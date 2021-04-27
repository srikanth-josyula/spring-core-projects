package com.operations.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.operations.dao.PersonDAO;
import com.operations.entities.PersonEntity;

@Repository(value = "personDAO")
public class PersonDAOImpl implements PersonDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void create(PersonEntity prs) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(prs);
		tx.commit();
		session.close();

	}

}
