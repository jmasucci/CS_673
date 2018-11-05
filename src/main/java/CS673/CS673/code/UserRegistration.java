package CS673.CS673.code;


public class UserRegistration {

    private String firstName;
    private String lastName;
    private String password;
    private String confirmpw;
    private String email;
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
		// TODO Auto-generated method stub
		return password;
	}
}