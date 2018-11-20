package CS673.CS673.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import CS673.CS673.persistance.dao.UserRepository;
import CS673.CS673.persistance.model.User;

@Component
public class DemoData implements ApplicationRunner {

    @Autowired
    private UserRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK");
    	User test = new User();
    	test.setFullname("test test");
    	test.setEmail("test@test.test");
    	test.setPassword(new BCryptPasswordEncoder(12).encode("test"));
    	test.setGender("male");
    	test.setAge(22);
    	test.setCity("princeton");
    	test.setPets("none");
    	test.setDrinks("never");
    	test.setSmokes("never");
    	test.setRoomprice("$800-$1200");
    	test.setRoommates("2");
    	test.setEthnicity("black");
    	test.setReligion("agnostic");
    	test.setPhysical("");
    	test.setDescription("");
    	
    	User test2 = new User();
    	test2.setFullname("demo demo");
    	test2.setEmail("demo@demo.demo");
    	test2.setPassword(new BCryptPasswordEncoder(12).encode("demo"));
    	test2.setGender("female");
    	test2.setAge(25);
    	test2.setCity("boston");
    	test2.setPets("dog");
    	test2.setDrinks("frequently");
    	test2.setSmokes("frequently");
    	test2.setRoomprice("$1200-$1600");
    	test2.setRoommates("1");
    	test2.setEthnicity("white");
    	test2.setReligion("agnostic");
    	test2.setPhysical("Hey, I'm a demo");
    	test2.setDescription("Hey, I'm a demo");
    	
        repository.save(test);
        repository.save(test2);
	}
}