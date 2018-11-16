package CS673.CS673.code;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import CS673.CS673.validator.PasswordMatches;
import CS673.CS673.validator.ValidEmail;

@PasswordMatches
public class UserDto {

	@NotNull
	@Size(min = 1)
    private String fullname;
	
	@NotNull
	@Size(min = 1)
	private String password;
	
	@NotNull
	@Size(min = 1)
	private String confirmpw;
	
	@NotNull
	@Size(min = 1)
	private String gender;
	
	@NotNull
	@Size(min = 1)
	private String city;
	
	@NotNull
	@Size(min = 1)
	private String pets;
	
	@NotNull
	@Size(min = 1)
	private String drinks;
	
	@NotNull
	@Size(min = 1)
	private String smokes;
	
	@NotNull
	@Size(min = 1)
	private String roomprice;
	
	@NotNull
	@Size(min = 1)
	private String ethnicity;
	
	@NotNull
	@Size(min = 1)
	private String religion;
	
	private String physical;
	
	private String description;
	
	@NotNull
	@Size(min = 1)
	private String roommates;
	
	@ValidEmail
	@NotNull
	@Size(min = 1)
	private String email;
	
	@NotNull
	private Integer age;
     
    public String getFullname()
    {
		return fullname;
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
    public void setFullname(String fullname)
    {
		this.fullname = fullname;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPets() {
		return pets;
	}
	public void setPets(String pets) {
		this.pets = pets;
	}
	public String getDrinks() {
		return drinks;
	}
	public void setDrinks(String drinks) {
		this.drinks = drinks;
	}
	public String getRoommates() {
		return roommates;
	}
	public void setRoommates(String roommates) {
		this.roommates = roommates;
	}
	public String getSmokes() {
		return smokes;
	}
	public void setSmokes(String smokes) {
		this.smokes = smokes;
	}
	public String getRoomprice() {
		return roomprice;
	}
	public void setRoomprice(String roomprice) {
		this.roomprice = roomprice;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getReligion() {
		return religion;
	}
	public void setReligion(String religion) {
		this.religion = religion;
	}
	public String getPhysical() {
		return physical;
	}
	public void setPhysical(String physical) {
		this.physical = physical;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}