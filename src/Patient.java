import java.util.Date;


public class Patient {

	
	private String firstName;
	private String middleName;
	private String lastName;
	private Date dateOfBirth;
	private String gender;
	private String phoneNumber;
	private String email;
	private String street;
	private String city;
	private String state;
	private int zipCode;
	private String country;
	//private photo
	private int SSN;
	private String insurance;
	
	private int THCNumber;
	
	/* Dropdown: Gender, City, State, Country*/
	/* Optional: Middle name, E-mail, State, Photo, SSN, Insurance*/
	public Patient(String firstName, String lastName, Date dateOfBirth, String gender,
			String phoneNumber, String street, String city, int zipCode, String country)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.phoneNumber = phoneNumber;
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
		
	}
	
}
