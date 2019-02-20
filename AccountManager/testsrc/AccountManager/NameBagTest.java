package AccountManager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameBagTest {
	private NameBag nameBag;
	private final String BOYSNAMESFILE = "boys_names.txt";
	private final String GIRLSNAMESFILE = "girls_names.txt";
	private final String LASTNAMESFILE = "last_names.txt";
	
	@Test
	void testLoadFile() {
		try {
			nameBag = new NameBag(BOYSNAMESFILE, GIRLSNAMESFILE, LASTNAMESFILE);
		} catch(IOException e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	void testEmitBoysFirstName() {
		fail("Not implemented.");
	}
	
	@Test
	void testEmitGirlsFirstName() {
		fail("Not implemented.");
	}
	
	@Test
	void testEmitLastName() {
		fail("Not implemented.");
	}

}
