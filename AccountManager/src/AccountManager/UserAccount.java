package AccountManager;

public class UserAccount {
	private String firstName;
	private String lastName;
	private String userID;
	private boolean isMale;
	private String userName;
	private String password;
	private double GPA;
	
	public UserAccount(String firstName, String lastName, String userID, boolean isMale, String userName, String password, double GPA){
		this.firstName = firstName;
		this.lastName = lastName;
		this.userID = userID;
		this.isMale = isMale;
		this.userName = userName;
		this.password = password;
		this.GPA = GPA;
	}
	
	public String getFirstName() {
		return firstName;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getUserID() {
		return userID;
	}
	
	public boolean isMale() {
		return isMale;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public boolean checkPassword(String password) {
		return this.password.equals(password);
	}
	
	public double getGPA() {
		return GPA;
	}
}
