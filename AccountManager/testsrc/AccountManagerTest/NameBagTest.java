package AccountManager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameBagTest {
	private NameBag nameBag;
	private final String BOYSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/boys_names.txt";
	private final String GIRLSNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/girls_names.txt";
	private final String LASTNAMESFILE = "/home/aidan/Documents/cse248/AccountManager/src/AccountManager/last_names.txt";
	
	@BeforeEach
	void setup() {
		try {
			nameBag = new NameBag(BOYSNAMESFILE, GIRLSNAMESFILE, LASTNAMESFILE);
		} catch(IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testGetBoysName() {
		for(int i = 0; i < 3000; i++) {
			assertEquals(true, nameBag.getBoysName().length() > 0);
			assertEquals(false, nameBag.getBoysName().contains(" "));
		}
	}
	
	@Test
	void testGetGirlsName() {
		for(int i = 0; i < 3000; i++) {
			assertEquals(true, nameBag.getGirlsName().length() > 0);
			assertEquals(false, nameBag.getGirlsName().contains(" "));
		}
	}
	
	@Test
	void testGetLastName() {
		for(int i = 0; i < 3000; i++) {
			assertEquals(true, nameBag.getLastName().length() > 0);
			assertEquals(false, nameBag.getLastName().contains(" "));
		}
	}
}
