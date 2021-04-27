package com.operations.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import com.operations.dao.PersonDAO;
import com.operations.dao.impl.PersonDAOImpl;
import com.operations.service.PersonService;
import com.operations.service.impl.PersonServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/Spring_Hibernate");
		dataSource.setUsername("postgres");
		dataSource.setPassword("admin");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean asfb = new LocalSessionFactoryBean();
		asfb.setDataSource(getDataSource());
		asfb.setHibernateProperties(getHibernateProperties());
		asfb.setPackagesToScan("com.operations.entities");
		return asfb;
	}

	private Properties getHibernateProperties() {
		 Properties properties = new Properties();
	        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
	        properties.put("hibernate.show_sql", false);
	        properties.put("hibernate.hbm2ddl.auto", "create");
	        
	        return properties;
	}

	@Bean
	public PersonDAO personDAO() {
		PersonDAOImpl empDao = new PersonDAOImpl();
		SessionFactory sf = getSessionFactory().getObject();
		empDao.setSessionFactory(sf);
		return empDao;
	}

	@Bean
	public PersonService personService() {
		PersonServiceImpl serice = new PersonServiceImpl();
		serice.setPersonDAO(personDAO());
		return serice;
	}
}