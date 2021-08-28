package home.tech.springjpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import home.tech.springjpa.entity.User;
import home.tech.springjpa.service.UserRepository;

@Component
public class UserRepositoryCommandlineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandlineRunner.class);

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Halder","Admin");
		userRepository.save(user); //this method is used for both insert and update
		Optional<User> userWithOne= userRepository.findById(1L);
		
		log.info("User retrieved -> "+userWithOne);
		
		List<User> list = userRepository.findAll();
		log.info("Users List : "+list);
		
	}

}
