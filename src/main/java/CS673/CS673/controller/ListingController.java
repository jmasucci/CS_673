package CS673.CS673.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import CS673.CS673.persistance.model.User;

@Controller
public class ListingController {

	@RequestMapping(value = "/listings_index", method = RequestMethod.GET)
	public String viewListing(Map<String, Object> model)
	{
		return "listings_index";
	}	
}