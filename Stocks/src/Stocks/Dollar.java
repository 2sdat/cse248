package Stocks;

public class Dollar {
	private String currency;
	private double price;
	private double rate;
	private RateBag rateBag;

	public Dollar(String currency, double price) {
		this.price = price;
		this.currency = currency;
		this.rate = getRate(currency);
	}
	
	private double getRate(String currency2) {
		
	}

	public double getDollarAmount() {
		return price / rate;
	}
	
	
}
