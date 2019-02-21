package AccountManagerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AccountManager.UserAccount;
import AccountManager.UserBag;

class UserBagTest {
	private UserBag userBag;
	private UserAccount user1;
	private UserAccount user2;
	private UserAccount userNameDupe;
	private UserAccount userIDDupe;
	private UserAccount userNotInBag;
	
	@BeforeEach
	void setUp() throws Exception {
		userBag = new UserBag(30);
		
		user1 = new UserAccount("Aidan", "Courtney", "12345678", true, "CourA8", "Abcd123$", 3.99);
		userBag.addUser(user1);
		
		user2 = new UserAccount("Rowan", "Courtney", "12345679", true, "CourR9", "Efgh987^", 2.5);
		userBag.addUser(user2);
		
		userNameDupe = new UserAccount("Alba", "Courtney", "12345698", false, "CourA8", "Abcd123$", 3.99);
		userIDDupe = new UserAccount("Peter", "Courntey", "12345678", true, "CourP8", "Abg34%", 1.5);
		userNotInBag = new UserAccount("Alba", "Tribino", "98765432", false, "TribA2", "Abgfkkj1@", 3.5);
	}
	
	@Test
	void testAddUser() {
		try {
			userBag.addUser(userNotInBag);
		} catch (IllegalArgumentException e) {
			fail(e.getMessage());
		}
		
		assertThrows(IllegalArgumentException.class, () -> {userBag.addUser(userNameDupe);});
		assertThrows(IllegalArgumentException.class, () -> {userBag.addUser(userIDDupe);});
	}
	
	@Test
	void testAddNewUser() {
		assertThrows(IllegalArgumentException.class, () -> {userBag.addNewUser("Aidan", "Courtney", true, "CourA8", "Abcd123$", 3.99);});
		try {
			userBag.addNewUser("Theresa", "Sweeney", false, "Abcd123%", 2.55);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testLoginUser() {
		assertEquals(true, userBag.loginUser(user1.getUserName(), "Abcd123$"));
		assertEquals(false, userBag.loginUser(user1.getUserName(), ""));
		assertEquals(false, userBag.loginUser(user1.getUserName(), "1234"));
		assertEquals(false, userBag.loginUser("SweeT7", "Abdcf81#"));
	}
	
	@Test
	void testGetUserList() {
		ArrayList<String> users = userBag.getUserList();
		assertEquals(true, users.contains(user1.getUserName()));
		assertEquals(true, users.contains(user2.getUserName()));
		assertEquals(false, users.contains(null));
		assertEquals(false, users.contains(""));
		assertEquals(false, users.contains("Abgdk12"));
	}
}
