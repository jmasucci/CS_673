package CS673.CS673.persistance.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User implements Serializable
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Integer id;
	
	private String fullname;
	
    private String password;
    
	private String gender;
	
	private String city;
	
	private String pets;
	
	private String drinks;
	
	private String smokes;
	
	private String roomprice;
	
	private String ethnicity;
	
	private String religion;
	
	private String physical;
	
	private String description;
	
	private String email;
	
	private String roommates;
	
	private Integer age;
	
	public Integer getId()
	{
		return id;
	}
	
	public void setId(Integer id)
	{
		this.id = id;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public Integer getAge()
	{
		return age;
	}
	
	public void setAge(Integer age)
	{
		this.age = age;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
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

	public String getRoommates() {
		return roommates;
	}

	public void setRoommates(String roommates) {
		this.roommates = roommates;
	}
}