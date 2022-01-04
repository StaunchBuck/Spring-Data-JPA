package com.tech.hibernate.JPAHibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tech.hibernate.JPAHibernate.entity.Course;

@Repository
//@Transactional(propagation = Propagation.REQUIRED) -> not mandatory to define Transactional..by default transactional is Required and spring container will create one if not defined
public class CourseRepository {
	
	//@PersistenceContext  or @Autowired
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) { //doesnt require a transaction as no data is getting modified
		return em.find(Course.class, id);
	}
	
	public List<Course> getAllCourses(){

		//Query query= em.createNamedQuery("query_get_all_courses");
//		TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses",Course.class);
		Query query= em.createNativeQuery("select * from course_details where id = ?",Course.class);
		query.setParameter(1, 1);
		return query.getResultList();
	}
	
	@Transactional
	public int updateByativeQuery() {
		Query query = em.createNativeQuery("update course_details set name = :name where id = :id");
		query.setParameter("id", 10004);
		query.setParameter("name", "Subbu");
		int i=query.executeUpdate();
		return i;
	}
	@Transactional
	public Course save(Course course) { // -> insert or save
		if(course.getId() == null)
			em.persist(course);
		else
			em.merge(course);
		return course;
	}
	@Transactional
	public void deleteById(Long id) {
		em.remove(em.find(Course.class, id));
	}

	@Transactional
	public void playWithEntityManager() { 
		
		//even after you modify the course after persist, then also it would reflect in db bcoz the whole method is under a single transaction
		Course newCourse = new Course("New Course Setup");
		em.persist(newCourse);
		newCourse.setName("New Course Setup Updated");
	}
	
	@Transactional
	public void play() {
		try {
			Course course1 = new Course("Angular Setup");
			em.persist(course1);
			em.flush(); // flushes the changes uptill now to database
			int a=1/0; // throws exception but still the course object is saved in db bcoz we already flushed/synchronized the object in db
			course1.setName("Angular Setup - Updated"); // wont happen bcoz of above exception
		}catch (Exception e) {
			
		}
	}
	
	@Transactional
	public void playAgain() { 
		// still the course object wont even be saved in db bcoz the object is detached before even getting saved in db.
		// By default, the whole object will be saved to db after the method is complete.
		Course course = new Course("Kafka Setup");
		em.persist(course);
		em.detach(course);
		course.setName("Kafka Setup Updated");
		
	}
	
	@Transactional
	public void playYetAgain() { 
		// Now the object would get saved in db but the update to name wont happen bcoz the object is detached
		//and after detached, that specific entity is not tracked by the entitymanager
		Course course = new Course("JMS Setup");
		em.persist(course);
		em.flush();
		em.detach(course);
		//em.clear(); //this would detach all entity tracked by this entitymanager.
		course.setName("JMS Setup Updated");
		
	}
	
	@Transactional
	public void playOneMoreTime(Course c) { // the object is saved with no issues
		em.persist(c);
		em.flush();
		em.clear();
	}
	
	@Transactional
	public void playLastTime(Course c) { 
		// this wont be saved as this entity is cleared out of 
		//EntityManager by the method playOneMoreTime. An exception would be thrown as 
		//Caused by: org.hibernate.PersistentObjectException: detached entity passed to persist: com.tech.hibernate.JPAHibernate.entity.Course
		em.persist(c);
		c.setName("Entity Object with detach - Updated");
	}

	@Transactional
	public void playWithRefresh() {
		Course c1 = new Course("Learning JPA");
		em.persist(c1);
		
		Course c2 = new Course("Learning JDBCTemplate");
		em.persist(c2);
		
		em.flush();
		
		c1.setName("Learning JPA - Updated");
		c2.setName("Learning JDBCTemplate - Updated");
		
		em.refresh(c1);  // refreshes the content of c1 with that of database.Therefore line 129 changes would be lost.
	}
}
