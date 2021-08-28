package home.tech.springjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import home.tech.springjpa.entity.User;
import home.tech.springjpa.service.UserDAOService;

@Component
public class UserDAOServiceCommandlineRunner implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandlineRunner.class);

	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		User user = new User("Subhasish","Admin");
		long id = userDaoService.insert(user);
		log.info("New User is created with id -> "+user);
		
	}

}
