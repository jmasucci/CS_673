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
    	
    	User test3 = new User();
    	test3.setFullname("Han Solo");
    	test3.setEmail("test2@test.test");
    	test3.setPassword(new BCryptPasswordEncoder(12).encode("test"));
    	test3.setGender("male");
    	test3.setAge(30);
    	test3.setCity("princeton");
    	test3.setPets("none");
    	test3.setDrinks("never");
    	test3.setSmokes("never");
    	test3.setRoomprice("$800-$1200");
    	test3.setRoommates("2");
    	test3.setEthnicity("black");
    	test3.setReligion("agnostic");
    	test3.setPhysical("");
    	test3.setDescription("");
    	
    	User test4 = new User();
    	test4.setFullname("Obi-Wan Kenobi");
    	test4.setEmail("test3@test.test");
    	test4.setPassword(new BCryptPasswordEncoder(12).encode("test"));
    	test4.setGender("male");
    	test4.setAge(25);
    	test4.setCity("princeton");
    	test4.setPets("cat");
    	test4.setDrinks("frequently");
    	test4.setSmokes("frequently");
    	test4.setRoomprice("$800-$1200");
    	test4.setRoommates("1");
    	test4.setEthnicity("white");
    	test4.setReligion("agnostic");
    	test4.setPhysical("Hey, I'm a demo");
    	test4.setDescription("Hey, I'm a demo");
    	
    	User test5 = new User();
    	test5.setFullname("Bruce Wayne");
    	test5.setEmail("test4@test.test");
    	test5.setPassword(new BCryptPasswordEncoder(12).encode("test"));
    	test5.setGender("male");
    	test5.setAge(25);
    	test5.setCity("princeton");
    	test5.setPets("cat");
    	test5.setDrinks("frequently");
    	test5.setSmokes("frequently");
    	test5.setRoomprice("$800-$1200");
    	test5.setRoommates("1");
    	test5.setEthnicity("white");
    	test5.setReligion("agnostic");
    	test5.setPhysical("Hey, I'm a demo");
    	test5.setDescription("Hey, I'm a demo");
    	
        repository.save(test);
        repository.save(test2);
        repository.save(test3);
        repository.save(test4);
        repository.save(test5);
	}
}