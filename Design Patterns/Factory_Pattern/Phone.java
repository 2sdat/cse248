package Factory_Pattern;

public abstract class Phone {
	private String phoneNumber;
	
	public abstract String getCountryCode();
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		try {
			Long.parseLong(phoneNumber);
			this.phoneNumber = phoneNumber;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}
