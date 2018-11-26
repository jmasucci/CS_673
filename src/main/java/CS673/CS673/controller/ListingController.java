package CS673.CS673.controller;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import CS673.CS673.code.EmailDto;
import CS673.CS673.code.Search;
import CS673.CS673.persistance.model.User;
import CS673.CS673.service.IUserService;

@Controller
public class ListingController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/listings_index", method = RequestMethod.GET)
	public String viewListing(Map<String, Object> model)
	{
		return "listings_index";
	}
	
	@RequestMapping(value = "/single_listing_index/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView viewSingleListing(@PathVariable("id")int id,
										  ModelAndView model)
	{
		User user = userService.getUser(id);
		EmailDto emailDto = new EmailDto();
		model.addObject("user", user);
		model.addObject("emailDto", emailDto);
		model.setViewName("single_listing_index");
		return model;
	}
	
	@RequestMapping(value = "/single_listing_index/{id}", method = RequestMethod.POST)
	public String sendEmail(@PathVariable("id")int id,
							@ModelAttribute("emailDto") EmailDto form,
							ModelAndView model)
	{
		User user = userService.getUser(id);
		if (user == null || form == null)
			return "redirect:filter_search_index";

		User connected = userService.getUser(SecurityContextHolder.getContext().getAuthentication().getName());
		String returnPath = "redirect:" + user.getId();
		String message = form.getMessage();
		if (message != null && message.length() > 0)
		{
			String finalMessage = "Hi " + user.getFullname() + ",\n"
					+ "You have a message from " + connected.getFullname() + "(" + connected.getEmail() + ") using Roommate Finder:\n\n"
					+ message + "\n\n\n"
					+ "Please, do not respond to this email,\n"
					+ "Sincerely, Roommate finder team."; 
			
			try
			{
				JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
				
				
				mailSender.setHost("smtp.gmail.com");
			    mailSender.setPort(587);
			    
			    //TODO Big security issue
			    mailSender.setUsername("CS673BU@gmail.com");
			    mailSender.setPassword("CS673CS673");
			     
			    Properties props = mailSender.getJavaMailProperties();
			    props.put("mail.transport.protocol", "smtp");
			    props.put("mail.smtp.auth", "true");
			    props.put("mail.smtp.starttls.enable", "true");
			    props.put("mail.debug", "true");
				
				mailSender.send(new MimeMessagePreparator() {
						  public void prepare(MimeMessage mimeMessageObj) throws MessagingException {
						    MimeMessageHelper messageObj = new MimeMessageHelper(mimeMessageObj, true, "UTF-8");
						    messageObj.setFrom(connected.getEmail());
						    messageObj.setTo(user.getEmail());
						    messageObj.setSubject(form.getObject());
						    messageObj.setText(finalMessage);
						  }
						});
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		model.clear();
		return returnPath;
	}
	
}