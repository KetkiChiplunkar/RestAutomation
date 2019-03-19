package RestClasses;

import java.util.List;

public class Student {
	
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	private String programme;
	private List<String> courses;
	
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getemail() {
		return email;
	}
	public void setEmailAddress(String emailAddress) {
		this.email = emailAddress;
	}
	public String getprogramme() {
		return programme;
	}
	public void setprogramme(String programmer) {
		this.programme = programmer;
	}
	
}
