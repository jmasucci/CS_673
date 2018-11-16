package CS673.CS673.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import CS673.CS673.code.Search;

@EnableWebMvc
@Controller
public class SearchController {
	
	@RequestMapping(value = "/filter_search_index", method = RequestMethod.GET)
	public String Login(Map<String, Object> model) {
		Search searchForm = new Search();
		model.put("searchForm", searchForm);
		//model.put("firstName", userForm.);

		
		return "filter_search_index";
	}
	
	@RequestMapping(value = "/filter_search_index", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("searchForm") Search form, 
			Map<String, Object> model) {
		
		Search searchForm = new Search();
		model.put("searchForm", searchForm);
		//model.put("firstName", userForm.);

		return "filter_search_index";
	}

}
