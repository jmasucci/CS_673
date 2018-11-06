package CS673.CS673.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CS673.CS673.code.UserDto;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String Login(Map<String, Object> model) {
		UserDto userForm = new UserDto();
		model.put("userForm", userForm);
		return "Registration";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("userForm") UserDto user, 
			Map<String, Object> model) {
				return null;
	}
}
