package CS673.CS673.code;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProfileDto {
	
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
	
	@NotNull
	private Integer age;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
