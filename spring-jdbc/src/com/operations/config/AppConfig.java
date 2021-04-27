package com.operations.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.operations.dao.PersonDAO;
import com.operations.dao.impl.PersonDAOImpl;
import com.operations.service.PersonService;
import com.operations.service.impl.PersonServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/Spring_JDBC");
		dataSource.setUsername("postgres");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
    public PersonDAO personDAO(){
		PersonDAOImpl empDao = new PersonDAOImpl();
        empDao.init(dataSource());
        return empDao;
    }
	
	@Bean
	public PersonService personService()  {
		PersonServiceImpl serice = new PersonServiceImpl();
		serice.setPersonDAO(personDAO());
		return serice;
	}

}