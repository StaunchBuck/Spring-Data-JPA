package com.home.database.databasedemo.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.home.database.databasedemo.entity.Person;

@Repository
public class PersonJdbcDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper(Person.class));
	}

}
