package CS673.CS673.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
		    return "redirect:/filter_search_index";
		}
		return "Login";
	}
}
