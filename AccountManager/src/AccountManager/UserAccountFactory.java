package AccountManager;

import java.io.IOException;
import java.util.Random;

public class UserAccountFactory {
	public NameBag nameBag;
	private boolean isMale;
	private Random rand;
	private final String ALPHAUPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final String ALPHALOWER = "abcdefghijklmnopqrstuvwxyz";
	private final String DIGITS = "0123456789";
	private final String SPECCHARS = " !\\\"\\\\#$%&'()*+,-./:;<=>?@[]^_`{|}~";
	
	
	public UserAccountFactory() throws IOException {
		nameBag = new NameBag();
	}
	
	public UserBag populateUserBag() {
		rand = new Random();
		UserBag userBag = new UserBag();
		for(int i = 0; i < 3000; i++) {
			userBag.addNewUser(emitFirstName(), emitLastName(), isMale, emitPassword(), emitGPA());
		}
		return userBag;
	}

	private double emitGPA() {
		return 4*rand.nextDouble();
	}

	private String emitPassword() {
		String password = "";
		password += ALPHAUPPER.charAt(rand.nextInt(ALPHAUPPER.length()));
		password += ALPHALOWER.charAt(rand.nextInt(ALPHALOWER.length()));
		password += DIGITS.charAt(rand.nextInt(DIGITS.length()));
		password += SPECCHARS.charAt(rand.nextInt(SPECCHARS.length()));
		for(int i = 0; i < 6; i++) {
			switch(rand.nextInt(4)) {
			case 0:
				password += ALPHAUPPER.charAt(rand.nextInt(ALPHAUPPER.length()));
			case 1:
				password += ALPHALOWER.charAt(rand.nextInt(ALPHALOWER.length()));
			case 2:
				password += DIGITS.charAt(rand.nextInt(DIGITS.length()));
			case 3:
				password += SPECCHARS.charAt(rand.nextInt(SPECCHARS.length()));
			}
		}
		return password;
	}

	private String emitLastName() {
		return nameBag.getLastName();
	}

	private String emitFirstName() {
		Random rand = new Random();
		if(rand.nextBoolean()) {
			isMale = true;
			return nameBag.getBoysName();
		}
		isMale = false;
		return nameBag.getGirlsName();
	}
}
