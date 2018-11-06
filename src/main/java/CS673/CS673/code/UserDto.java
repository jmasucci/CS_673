package CS673.CS673.code;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import CS673.CS673.validator.PasswordMatches;
import CS673.CS673.validator.ValidEmail;

@PasswordMatches
public class UserDto {

	@NotNull
	@Size(min = 1)
    private String firstName;
	
	@NotNull
	@Size(min = 1)
    private String lastName;
	
	@NotNull
	@Size(min = 1)
	private String password;
	
	@NotNull
	@Size(min = 1)
	private String confirmpw;
	
	@ValidEmail
	@NotNull
	@Size(min = 1)
	private String email;
	
	@NotNull
	private Integer age;
     
    public String getFirstName()
    {
		return firstName;
    }
    public String getLastName()
    {
		return lastName;
    }
	public Integer getAge()
	{
		return age;
	}
    public String getEmail()
    {
		return email;
    }
    public String getConfirmpw()
    {
    	return confirmpw;
    }
    public void setPassword(String pw)
    {
		password = pw;
    }
    public void setConfirmpw(String pw)
    {
		confirmpw = pw;
    }
    public void setFirstName(String first)
    {
		firstName = first;
    }
    public void setLastName(String last)
    {
		lastName = last;
    }
    public void setEmail(String emailaddress)
    {
		email = emailaddress;
    }
	public void setAge(Integer inputage)
	{
		age = inputage;
	}
	public String getPassword() {
		return password;
	}
}