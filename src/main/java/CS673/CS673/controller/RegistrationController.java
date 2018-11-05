package CS673.CS673.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.mindrot.jbcrypt.BCrypt;

import CS673.CS673.code.UserRegistration;
import CS673.CS673.database.User;
import CS673.CS673.database.UserRepository;

@Controller
@RequestMapping(value = "/register")
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		UserRegistration userForm = new UserRegistration();
		model.put("userForm", userForm);
		return "Registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") UserRegistration userRegistration, 
			Map<String, Object> model) {

		// Check error here. (password and confirm password match, already exists, ...)
		String password = userRegistration.getPassword();
		String confirmPassword = userRegistration.getConfirmpw();
		
		if (!(password.equals(confirmPassword)))
		{
			// insert error type
			System.out.println("Passwords doesn't match : " + password + " - " + confirmPassword);
			return "Registration";
		}
		
		String email = userRegistration.getEmail();
		List<User> persons = userRepository.findByEmail(email);
		
		if (persons.size() > 0)
		{
			// insert error type
			System.out.println("An account already exists with the email : " + email);
			return "Registration";
		}
		
		// End error checking
		
		// Hash password
		String hashed = BCrypt.hashpw(password, BCrypt.gensalt(12));
				
		// Create user entity
		User user = new User();
		user.setAge(userRegistration.getAge());
		user.setEmail(email);
		user.setFirstName(userRegistration.getFirstName());
		user.setLastName(userRegistration.getLastName());
		user.setPassword(hashed);
		
		// Save entity in database
		userRepository.save(user);
		
		System.out.println("password: " + user.getPassword());
		System.out.println("username: " + user.getFirstName());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("birth date: " + user.getAge());
		return "RegistrationSuccess";
	}
}

