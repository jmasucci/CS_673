package CS673.CS673.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.RedirectView;

import CS673.CS673.code.UserRegistration;

@EnableWebMvc
@Controller
public class HomeController {

	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		UserRegistration userForm = new UserRegistration();
		System.out.println(userForm.getFirstName());
		model.put("userForm", userForm);
		//model.put("firstName", userForm.);
		
		return "Registration";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") UserRegistration user, 
			Map<String, Object> model) {
		
		String url = "jdbc:mysql://localhost:3306/school_project";
		String username = "java";
		String password = "password";
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		Connection connection = null;
		ResultSet resultSet = null;
	
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Connecting database...");
		try{
		   connection = DriverManager.getConnection(url, username, password);
		   String sql1 = "Select count(*) from login_table where email=?";
		   statement1 = connection.prepareStatement(sql1);
		   statement1.setString(1, user.getEmail());
		   System.out.println(user.getEmail());
		   resultSet = statement1.executeQuery();
		   int counter = 0;
		   if(!resultSet.isBeforeFirst())
		   {
			   counter++;
		   }
		   
		   if(counter> 0)
		   {
		   System.out.println(counter);
		   // update to insert error message (may need to redirect to new page with information
		   // fill in )
		   counter = 0;
		   return "Registration";
		   }
		   
		   // validate all fields are Strings and that age is a # 
		   
		   String sql = "INSERT INTO login_table (email, password, first_name, last_name, age) VALUES (?, ?, ?, ?, ?)";
		   statement = connection.prepareStatement(sql);
		   statement.setString(1, user.getEmail());
		   String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
		   user.setpassword(hashed);
		   statement.setString(2, hashed);
		   statement.setString(3, user.getFirstName());
		   statement.setString(4, user.getLastName());
		   statement.setLong(5, user.getAge());
		   statement.executeUpdate();
		   
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		finally{
		      try{
			         if(resultSet!=null)
			        	 connection.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			
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
		
		
		
		return "RegistrationSuccess"; // this needs to go to the Profile Creation Java "(redirect:/profile)"
	}
	
	// handle login

	/*
	 * if (BCrypt.checkpw(candidate, hashed)) 
	 * System.out.println("It matches"); 
	 * else
	 * System.out.println("It does not match");
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String Login(Map<String, Object> model) {
		UserRegistration userForm = new UserRegistration();
		System.out.println(userForm.getFirstName());
		model.put("userForm", userForm);
		//model.put("firstName", userForm.);
		
		return "Login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String processLogin(@ModelAttribute("userForm") UserRegistration user, 
			Map<String, Object> model) {
		
		String url = "jdbc:mysql://localhost:3306/school_project";
		String username = "java";
		String password = "password";
		PreparedStatement statement = null;
		PreparedStatement statement1 = null;
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Connecting database...");
		try{
		   connection = DriverManager.getConnection(url, username, password);
		   String sql1 = "Select password from login_table where email=?";
		   statement1 = connection.prepareStatement(sql1);
		   statement1.setString(1, user.getEmail());
		   System.out.println(user.getEmail());
		   resultSet = statement1.executeQuery();
		   resultSet.next();
		   String pass = resultSet.getString(1);
		   System.out.println(pass);
		  
		   if(BCrypt.checkpw(user.getPassword(), pass))
		   {
			   //safeRedirect("http://localhost:8080/CS673/filter_search_index");
			   return "redirect:/filter_search_index";
		   }
		  
		   
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		finally{
		      try{
			         if(resultSet!=null)
			        	 connection.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			
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
				
		
		return "Login";
	
	}
}

