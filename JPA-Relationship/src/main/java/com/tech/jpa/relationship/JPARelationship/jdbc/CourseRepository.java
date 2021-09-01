package com.tech.jpa.relationship.JPARelationship.jdbc;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager em;
	
}
