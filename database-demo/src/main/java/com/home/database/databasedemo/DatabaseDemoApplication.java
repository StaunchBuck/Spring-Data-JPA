package com.home.database.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.home.database.databasedemo.entity.Person;
import com.home.database.databasedemo.jdbc.PersonJdbcDAO;

//@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(DatabaseDemoApplication.class);
	@Autowired
	PersonJdbcDAO personDao;
	
	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Person fetched -> "+personDao.findAll());
		
		log.info("Person fetcched by ID 10002-> "+personDao.findById(10002));
		
		log.info("Person delete by ID 10001-> "+personDao.deleteById(10002));
		
		log.info("Insert Person -> "+personDao.insert(new Person(10008,"Sonam","Berlin",new Date())));
		
		log.info("Update Person -> "+personDao.update("Sonam_",10008));
		
	}

}
