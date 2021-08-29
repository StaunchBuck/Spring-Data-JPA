package com.home.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.home.database.databasedemo.entity.Person;
import com.home.database.databasedemo.jdbc.PersonJPARepository;
import com.home.database.databasedemo.jdbc.PersonJdbcDAO;

@SpringBootApplication
public class JPADemoApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(JPADemoApplication.class);
	
	@Autowired
	PersonJPARepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JPADemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("Person fetched by ID 10001-> "+repository.findById(10001));
		
		log.info("Insert Person -> "+repository.insert(new Person(10008,"Sonam","Berlin",new Date())));
		
		log.info("Update Person -> "+repository.update(new Person(10008,"Sonam_","Berlin",new Date())));
		
		log.info("Delete Person 10004-> ");
		repository.delete(10004);
		
		log.info("Persons fetched -> "+repository.findAll());
		
		/*
		
		log.info("Person fetched -> "+personDao.findAll());
		
		log.info("Person delete by ID 10001-> "+personDao.deleteById(10002));
		
		log.info("Insert Person -> "+personDao.insert(new Person(10008,"Sonam","Berlin",new Date())));
		
		log.info("Update Person -> "+personDao.update("Sonam_",10008));
		*/
	}

}
