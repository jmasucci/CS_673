package CS673.CS673.code;

public class Search {
	private String gender;
	private String state;
	private String smoking;
	private String drinking;
	private String pets;
	private String agerange;
	private String idealroomprice;
	private String numberofroommates;

	public String getgender() {
		return gender;
	}

	public String getidealprice() {
		return idealroomprice;
	}

	public String getnumberofroommates() {
		return numberofroommates;
	}

	public String getstate() {
		return state;
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

	public void setsmokingconfirm(String drinkingfreq) {
		drinking = drinkingfreq;
	}

	public void setgender(String inputgender) {
		gender = inputgender;
	}

	public void setstate(String inputstate) {
		state = inputstate;
	}

	public void setpets(String inputpet) {
		pets = inputpet;
	}

	public void setagerange(String inputagerange) {
		agerange = inputagerange;
	}

	public String getsmoking() {
		// TODO Auto-generated method stub
		return smoking;
	}

	public void setidealprice(String idealprice) {
		idealroomprice = idealprice;
	}

	public void getnumberofroommates(String numberroommates) {
		numberofroommates = numberroommates;
	}
}
