package CS673.CS673.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import CS673.CS673.code.UserDto;
import CS673.CS673.error.EmailExistsException;
import CS673.CS673.persistance.model.User;
import CS673.CS673.service.IUserService;
import CS673.CS673.persistance.dao.UserRepository;

@Controller
public class RegistrationController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private IUserService userService;
	
	public RegistrationController() {
        super();
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		UserDto userForm = new UserDto();
		model.put("userForm", userForm);
		return "Registration";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistration(@Valid @ModelAttribute("userForm") UserDto userRegistration, 
			 BindingResult result, 
			  WebRequest request, 
			  Errors errors) {
		
		User registered = new User();
		if (!result.hasErrors()) {
			registered = createUserAccount(userRegistration, result);
		}
		if (registered == null) {
			result.rejectValue("email", "message.regError");
		}
		if (result.hasErrors()) {
			return new ModelAndView("Registration", "userForm", userRegistration);
		}
		else {
			return new ModelAndView("RegistrationSuccess", "userForm", userRegistration);
		}	
	}
	
	private User createUserAccount(UserDto userRegistration, BindingResult result) {
		User registered = null;
		try {
			registered = userService.registerNewUserAccount(userRegistration);
		} catch (EmailExistsException e) {
			return null;
		}
		return registered;
	}
}

