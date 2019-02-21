package AccountManagerTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AccountManager.UserAccount;

class UserAccountTest {
	private UserAccount user;
	@BeforeEach
	void setUp() throws Exception {
		user = new UserAccount("Aidan", "Courtney", "12345678", true, "CourA8", "AbCd123$", 3.96);
	}

	@Test
	void testPasswordCheck() {
		assertEquals(true, user.checkPassword("AbCd123$"));
		assertEquals(false, user.checkPassword("abcd123%"));
		assertEquals(false, user.checkPassword("abCd123$"));
		assertEquals(false, user.checkPassword(""));
	}
	
	@Test
	void testValidatePassword() {
		assertEquals(true, UserAccount.validatePassword("Abcdef1!"));
		assertEquals(false, UserAccount.validatePassword("Abcdef1f"));
		assertEquals(false, UserAccount.validatePassword("Abcdeff!!"));
		assertEquals(false, UserAccount.validatePassword("##aaFF4"));
		assertEquals(false, UserAccount.validatePassword(""));
		assertEquals(false, UserAccount.validatePassword(null));
		assertEquals(false, UserAccount.validatePassword("#####44FF"));
		assertEquals(false, UserAccount.validatePassword("#####44ff"));
		assertEquals(false, UserAccount.validatePassword("#####aaFF"));
	}
}
