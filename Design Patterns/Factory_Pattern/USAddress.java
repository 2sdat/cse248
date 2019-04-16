package Factory_Pattern;

public class USAddress extends Address {
	private static final String COUNTRY = "U.S.A.";
	private static final String COMMA = ",";
	
	@Override
	public String getCountry() {
		return COUNTRY;
	}
	
	@Override
	public String getFullAddress() {
		return getStreet() + EOL_STRING
				+ getCity() + COMMA + SPACE + getRegion() + SPACE + getPostalCode() + EOL_STRING
				+ COUNTRY + EOL_STRING;
	}
}
