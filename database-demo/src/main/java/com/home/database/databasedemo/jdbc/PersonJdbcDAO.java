package com.home.database.databasedemo.jdbc;

import java.sql.Timestamp;
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Person> findAll() {
		return jdbcTemplate.query("select * from Person", new BeanPropertyRowMapper(Person.class));
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Person findById(int id) {
		return (Person)jdbcTemplate.queryForObject("select * from Person where id = ?",new Object[] {id}, new BeanPropertyRowMapper(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from Person where id = ?",new Object[] {id});
	}
	
	public int insert(Person person) {
		return jdbcTemplate.update("insert into Person (id,name,location,birth_date) values(?,?,?,?)",
				new Object[] {person.getId(),person.getName(),person.getLocation(),new Timestamp(person.getBirthDate().getTime())});
	}

	public int update(String name,int id) {
		return jdbcTemplate.update("update Person set name = ? where id = ?",new Object[] {name,id});
	}
}
