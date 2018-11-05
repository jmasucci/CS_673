package CS673.CS673.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CS673.CS673.code.UserRegistration;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String Login(Map<String, Object> model) {
		UserRegistration userForm = new UserRegistration();
		model.put("userForm", userForm);
		return "Registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("userForm") UserRegistration user, 
			Map<String, Object> model) {
				return null;
	}
}
