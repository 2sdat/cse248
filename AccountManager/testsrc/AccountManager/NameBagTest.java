package AccountManager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NameBagTest {
	private NameBag nameBag;
	private String boysNamesFile;
	private String girlsNamesFile;
	private String lastNamesFile;
	
	@BeforeEach
	void setUp() throws Exception {
		nameBag = new NameBag();
		boysNamesFile = "boys_names.txt";
		girlsNamesFile = "girls_names.txt";
		lastNamesFile = "last_names.txt";
	}
	
	@Test
	void testLoadFile() {
		try {
			nameBag.loadNames(boysNamesFile, girlsNamesFile, lastNamesFile);
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
