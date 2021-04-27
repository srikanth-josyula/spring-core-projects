package com.operations.client;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.operations.config.AppConfig;
import com.operations.entities.PersonEntity;
import com.operations.service.PersonService;

public class JavaBackedClient {
	public static void main(String[] args) throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);

		PersonService personService = (PersonService) context.getBean(PersonService.class);
		PersonEntity emp1 = new PersonEntity(1320, "Srikanth", "kanth@xyz.com");
		personService.insertPerson(emp1);
		
		context.close();
		System.out.println("Record Created ...");
	}
}
