package Stocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DollarConversionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void testDollarConversion() {
		double actual = 0;
		Dollar dollar = new Dollar("CHF", 150.00);
		actual = dollar.getDollarAmount();
		assertEquals(100.00, actual);
	}

}
