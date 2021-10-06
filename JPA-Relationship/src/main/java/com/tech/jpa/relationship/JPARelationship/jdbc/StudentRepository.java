package com.tech.jpa.relationship.JPARelationship.jdbc;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.oracle.tools.packager.Log;
import com.tech.jpa.relationship.JPARelationship.JpaRelationshipApplication;
import com.tech.jpa.relationship.JPARelationship.entity.Passport;
import com.tech.jpa.relationship.JPARelationship.entity.Student;

@Repository
public class StudentRepository {
	
	private static final Logger log = LoggerFactory.getLogger(StudentRepository.class);
	
	@Autowired
	EntityManager em;
	
	@Transactional
	public void createStudentWithPassport() {
		log.info("creating student with passport");
		Passport pass = new Passport("XCD7822A");
		em.persist(pass);
		
		Student stu = new Student("Nick");
		stu.setPassport(pass);
		em.persist(stu);
		
	}
	
	@Transactional //is needed because you are also requesting the one to one mapping object
	public void retrieveStudentWithPassport() {  //one to one mapping are always eager fetched..even though you dont request passport details, still the passport details would be fetched
		Student stu = em.find(Student.class, 20001L);
		log.info("Student name :"+stu.getName());
		log.info("Student passport number :"+stu.getPassport().getNumber());
	}
	
}
