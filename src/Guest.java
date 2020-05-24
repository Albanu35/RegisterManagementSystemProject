import java.util.Scanner;

public class Guest {
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
			
	// getter and setters for each field
	public String getFirstName() {
		return this.firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//method of check 
	public boolean checkByName(String lastName, String firstName) {
		return this.getLastName().equals(lastName) && this.getFirstName().equals(firstName);
	}
	
	public boolean checkByEmail(String email) {
		return this.getEmail().equals(email);
	}
	
	public boolean checkByPhoneNumber(String phoneNumber) {
		return this.phoneNumber.equals(phoneNumber);
	}

}
