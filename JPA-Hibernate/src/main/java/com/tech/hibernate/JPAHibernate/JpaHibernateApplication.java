package com.tech.hibernate.JPAHibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tech.hibernate.JPAHibernate.entity.Course;
import com.tech.hibernate.JPAHibernate.repository.CourseRepository;

@SpringBootApplication
//@EnableTransactionManagement auto enables for spring boot
public class JpaHibernateApplication implements CommandLineRunner{

	private Logger log = LoggerFactory.getLogger(JpaHibernateApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(JpaHibernateApplication.class, args);
	}

	@Autowired CourseRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		log.info("Course fetched by id 10001 ->"+repository.findById(10001L));
		
		log.info("Course delete by Id 10001 ->");
		repository.deleteById(10001L);
		
		repository.save(new Course("Microservices"));
		repository.playWithEntityManager();
		repository.play();
		repository.playAgain();
		repository.playYetAgain();
		Course c = new Course("Entity Object with detach");
		repository.playOneMoreTime(c);
		//repository.playLastTime(c);
		repository.playWithRefresh();
		log.info("All courses : "+repository.getAllCourses());
		log.info("Updated no of rows: "+repository.updateByativeQuery());
	}

}
