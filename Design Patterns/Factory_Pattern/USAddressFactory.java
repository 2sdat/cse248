package Factory_Pattern;

public class USAddressFactory implements AddressFactory {

	@Override
	public Address createAddress() {
		return new USAddress();
	}

	@Override
	public Phone createPhoneNumber() {
		return new USPhoneNumber();
	}

}
