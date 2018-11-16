package CS673.CS673.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CS673.CS673.code.Profile;

public class ProfileCreation {
	@RequestMapping(value = "/profile",method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		Profile userForm = new Profile();
		//System.out.println(userForm.getFirstName());
		model.put("userForm", userForm);
		//model.put("firstName", userForm.);
		
		return "Registration";
	}
}
