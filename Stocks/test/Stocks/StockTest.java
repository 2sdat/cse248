package Stocks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StockTest {
	static StockBag theBag;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception{
		theBag = new StockBag(10);
		theBag.insert("IBM", 1000, 25);
		theBag.insert("GE", 400, 100);
	}
	
	@Test
	void test1() {
		double actual = 0.0;
		
		actual = theBag.getGrandTotal();
		
		assertEquals(65000, actual);
	}

}
