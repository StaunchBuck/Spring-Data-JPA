package home.tech.springjpa.service;

import org.springframework.data.jpa.repository.JpaRepository;

import home.tech.springjpa.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{ 

}
