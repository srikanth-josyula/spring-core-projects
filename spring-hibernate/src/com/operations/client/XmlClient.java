package com.operations.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.operations.entities.PersonEntity;
import com.operations.service.PersonService;

public class XmlClient {

	public static void main(String[] args) {
		ApplicationContext context = null;

		try {
			context = new ClassPathXmlApplicationContext("config.xml");
			PersonService personService = (PersonService) context.getBean("personservice");
			PersonEntity emp1 = new PersonEntity(1010, "Bob", "Account");
			personService.insertPerson(emp1);
			System.out.println("Records are successfully added..");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// context.close();
		}

	}
}
