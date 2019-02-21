package AccountManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
