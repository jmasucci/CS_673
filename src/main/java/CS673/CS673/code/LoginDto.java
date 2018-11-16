package CS673.CS673.code;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import CS673.CS673.validator.ValidEmail;

public class LoginDto {
	@ValidEmail
	@NotNull
	@Size(min = 1)
	private String email;
	
	@NotNull
	@Size(min = 1)
	private String password;
	
	public String getEmail()
	{
		return email;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
}