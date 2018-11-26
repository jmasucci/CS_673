package CS673.CS673.code;

public class Search {
	private String gender;
	private String city;
	private String smoking;
	private String drinking;
	private String pets;
	private String agerange;
	private String idealroomprice;
	private String numberofroommates;

	public String getgender() {
		return gender;
	}

	public String getidealroomprice() {
		return idealroomprice;
	}

	public String getnumberofroommates() {
		return numberofroommates;
	}

	public String getcity() {
		return city;
	}

	public String getagerange() {
		return agerange;
	}

	public String getpets() {
		return pets;
	}

	public String getdrinking() {
		return drinking;
	}

	public void setsmoking(String smokingfreq) {
		smoking = smokingfreq;
	}

	public void setdrinking(String drinkingfreq) {
		drinking = drinkingfreq;
	}

	public void setgender(String inputgender) {
		gender = inputgender;
	}

	public void setcity(String inputcity) {
		city = inputcity;
	}

	public void setpets(String inputpet) {
		pets = inputpet;
	}

	public void setagerange(String inputagerange) {
		agerange = inputagerange;
	}

	public String getsmoking() {
		return smoking;
	}

	public void setidealroomprice(String idealprice) {
		idealroomprice = idealprice;
	}

	public void setnumberofroommates(String numberroommates) {
		numberofroommates = numberroommates;
	}
}
