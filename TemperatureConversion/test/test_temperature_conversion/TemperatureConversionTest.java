package test_temperature_conversion;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TemperatureConversion.TemperatureConversion;

class TemperatureConversionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testCelsiusToFarenheit() {
		assertThrows(IllegalArgumentException.class, );
		assertEquals(32.0, TemperatureConversion.celsiusToFarenheit(0));
	}

}
