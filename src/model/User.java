package model;


public abstract class User {

	private String id;
	private String name;
	private String signUpDate;

	public User(String id, String name, String signUpDate) {
		this.id = id;
		this.name = name;
		this.signUpDate = signUpDate;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSignUpDate() {
		return signUpDate;
	}

	public void setSignUpDate(String signUpDate) {
		this.signUpDate = signUpDate;
	}

   
	

}
