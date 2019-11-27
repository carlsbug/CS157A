import java.util.Date;


public class Patient {

	
	private String firstName = "NULL";
	private String middleName= "NULL";
	private String lastName= "NULL";
	private String dateOfBirth= "NULL";
	private String gender= "NULL";
	private String phoneNumber= "NULL";
	private String email= "NULL";
	private String street= "NULL";
	private String city= "NULL";
	private String state= "NULL";
	private String zipCode= "NULL";
	private String country= "NULL";
    private String photo= "NULL";
	private String SSN= "NULL";
	private String insurance= "NULL";
	
	private int THCNumber;
	

	
	// Dropdown: Gender, City, State, Country
	// *Optional: Middle name, E-mail, State, Photo, SSN, Insurance
	public void addPatient(String firstName,String middleName, String lastName, String dateOfBirth, String gender,
			String phoneNumber,String email, String street, String city,String state, String zipCode, String country,String photo,String SSN, String insurance)
	{
		this.firstName = firstName;
		this.middleName = middleName; //*
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.email = email; //*
		this.street = street;
		this.city = city;
		this.state = state; //*
		this.zipCode = zipCode;
		this.country = country;
		this.SSN = SSN; //*
		this.insurance = insurance;
		
	}
	public String getFName() {
		return this.firstName;
	}
	
}
