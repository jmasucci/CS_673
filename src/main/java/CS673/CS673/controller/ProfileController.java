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

import CS673.CS673.code.LoginDto;
import CS673.CS673.code.ProfileDto;
import CS673.CS673.code.UserDto;
import CS673.CS673.error.BadPasswordException;
import CS673.CS673.error.UserNotExistsException;
import CS673.CS673.persistance.model.User;
import CS673.CS673.service.IUserService;

@Controller
public class ProfileController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		ProfileDto profileForm = new ProfileDto();
		model.put("profileForm", profileForm);
		return "Profile";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.POST)
	public ModelAndView processRegistration(@Valid @ModelAttribute("profileForm") ProfileDto profile, 
			 BindingResult result, 
			  WebRequest request, 
			  Errors errors) {
		User user = new User();
		if (!result.hasErrors()) {
			user = userService.updateUser(profile);
		}
		if (user == null) {
			result.rejectValue("email", "message.regError");
		}
		if (result.hasErrors()) {
			return new ModelAndView("Profile", "profileForm", profile);
		}
		else {
			return new ModelAndView("redirect:/filter_search_index");
		}
		
	}
	
}