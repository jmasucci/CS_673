package CS673.CS673.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import CS673.CS673.code.Search;
import CS673.CS673.persistance.model.User;
import CS673.CS673.service.IUserService;

@EnableWebMvc
@Controller
public class SearchController {
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/filter_search_index", method = RequestMethod.GET)
	public String viewFilter(Map<String, Object> model) {
		Search searchForm = new Search();
		model.put("searchForm", searchForm);
		return "filter_search_index";
	}

	@RequestMapping(value = "/filter_search_index", method = RequestMethod.POST)
	public ModelAndView processSearch(@ModelAttribute("searchForm") Search form, 
			Map<String, Object> model, BindingResult binding, 
            final RedirectAttributes redirectAttributes) {
		
		List<User> users = userService.makeSearch(form);
		if (users.size() == 0)
			users = null;
		redirectAttributes.addFlashAttribute("users", users);
		ModelAndView mv = new ModelAndView("redirect:/listings_index");
		return mv;
	}

}
