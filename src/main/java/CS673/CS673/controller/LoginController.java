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
import CS673.CS673.error.BadPasswordException;
import CS673.CS673.error.UserNotExistsException;
import CS673.CS673.persistance.model.User;
import CS673.CS673.service.IUserService;

@Controller
public class LoginController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Default()
	{
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Map<String, Object> model) {
		LoginDto userForm = new LoginDto();
		model.put("userForm", userForm);
		return "Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView processLogin(@Valid @ModelAttribute("userForm") LoginDto user, 
			 BindingResult result, 
			  WebRequest request, 
			  Errors errors) {
		User registered = new User();
		if (!result.hasErrors()) {
			registered = logUser(user, result);
		}
		if (registered == null) {
			// Bad password or user doesn't exists 
			//TODO make a distinction in logUser method
		}
		if (result.hasErrors()) {
			return new ModelAndView("Login", "userForm", user);
		}
		else {
			return new ModelAndView("redirect:/filter_search_index");
		}	
	}
	
	private User logUser(LoginDto user, BindingResult result) {
		User registered = null;
		try {
			registered = userService.logUser(user);
		} catch (UserNotExistsException e) {
			return null;
		}
		catch (BadPasswordException e) {
			return null;
		}
		return registered;
	}
}
