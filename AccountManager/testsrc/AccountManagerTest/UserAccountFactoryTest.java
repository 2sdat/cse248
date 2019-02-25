package AccountManagerTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import AccountManager.UserAccount;
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
			Hashtable<String, UserAccount> users = userBag.getUsers();
			assertEquals(3000, users.size());
			HashSet<String> userNameSet = new HashSet<String>();
			HashSet<String> idSet = new HashSet<String>();
			for(Map.Entry<String, UserAccount> user : users.entrySet()) {
				assertEquals(true, userNameSet.add(user.getValue().getUserName()));
				assertEquals(true, idSet.add(user.getValue().getUserID()));
				assertEquals(true, 0.0 <= user.getValue().getGPA() && user.getValue().getGPA() <= 4.0);
				assertEquals(true, UserAccount.validatePassword(user.getValue().getPassword()));
				assertEquals(user.getValue().isMale(), userFactory.nameBag.isMale(user.getValue().getFirstName()));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
}
