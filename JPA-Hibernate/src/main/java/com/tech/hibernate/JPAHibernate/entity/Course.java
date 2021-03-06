package com.tech.hibernate.JPAHibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="CourseDetails")
@NamedQueries(value = {
	@NamedQuery(name="query_get_all_courses", query="select c from Course c"),
	@NamedQuery(name="query_get_all_courses_like", query="select c from Course c where name like '%Web%'")	
})

public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="name",nullable=false,unique=false,length=255)
	private String name;
	
	@UpdateTimestamp
	private  LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	public Course() {}
	
	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
}
