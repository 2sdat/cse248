package AccountManagerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AccountManager.UserAccountFactory;
import AccountManager.UserBag;

class UserAccountFactoryTest {
	UserAccountFactory userFactory;
	private final String BOYSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/boys_names.txt";
	private final String GIRLSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/girls_names.txt";
	private final String LASTNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/last_names.txt";
	
	@BeforeEach
	void setUp() throws Exception {
		userFactory = new UserAccountFactory(BOYSNAMESFILE, GIRLSNAMESFILE, LASTNAMESFILE);
	}

	@Test
	void testCreateUsers() {
		try {
			UserBag userBag = userFactory.populateUserBag();
			ArrayList<String> users = userBag.getUserList();
			assertEquals(3000, users.size());
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
