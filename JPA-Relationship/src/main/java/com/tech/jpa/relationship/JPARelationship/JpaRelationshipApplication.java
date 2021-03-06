package com.tech.jpa.relationship.JPARelationship;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tech.jpa.relationship.JPARelationship.jdbc.StudentRepository;


@SpringBootApplication
//@EnableTransactionManagement auto enables for spring boot
public class JpaRelationshipApplication implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(JpaRelationshipApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipApplication.class, args);
	}

	@Autowired StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {
		studentRepository.createStudentWithPassport();
		studentRepository.retrieveStudentWithPassport();
	}

}
