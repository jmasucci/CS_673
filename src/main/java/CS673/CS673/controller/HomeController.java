package CS673.CS673.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import CS673.CS673.code.UserRegistration;

@Controller
@RequestMapping(value = "/register")
public class HomeController {

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		UserRegistration userForm = new UserRegistration();
		System.out.println(userForm.getFirstName());
		model.put("userForm", userForm);
		//model.put("firstName", userForm.);
		
		return "Registration";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") UserRegistration user, 
			Map<String, Object> model) {
		
		String url = "jdbc:mysql://localhost:3306/school_project";
		String username = "java";
		String password = "password";
		PreparedStatement statement = null;
		Connection connection = null;
		
	
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Connecting database...");
		try{
		   connection = DriverManager.getConnection(url, username, password);
		   String sql = "INSERT INTO login_table (email, password, first_name, last_name, age) VALUES (?, ?, ?, ?, ?)";
		   statement = connection.prepareStatement(sql);
		   statement.setString(1, user.getEmail());
		   statement.setString(2, user.getPassword());
		   statement.setString(3, user.getFirstName());
		   statement.setString(4, user.getLastName());
		   statement.setLong(5, user.getAge());
		   statement.executeUpdate();
		   
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(statement!=null)
		        	 connection.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(connection!=null)
		        	 connection.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		}
		/*
		 * Iterator<Entry<String, Object>> mapset = model.entrySet().iterator();
		 
		while(mapset.hasNext())
		{
			Entry<String, Object> pair = mapset.next();
			System.out.println("Pair:" + pair.getKey() + " " + pair.getValue());
		}
		*/
		
		//user =  model.get("userForm");
		
		
		// for testing purpose:
		System.out.println("password: " + user.getPassword());
		System.out.println("confirmed password: " + user.getconfirmpw());
		System.out.println("username: " + user.getFirstName());
		System.out.println("password: " + user.getPassword());
		System.out.println("email: " + user.getEmail());
		System.out.println("birth date: " + user.getAge());
		
		
		
		return "RegistrationSuccess";
	}
}

