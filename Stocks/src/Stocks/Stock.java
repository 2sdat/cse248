package Stocks;

public class Stock {
	private String instrument;
	private double price;
	private int shares;
	
	public Stock(String instrument, double price, int shares) {
		this.instrument = instrument;
		this.price = price;
		this.shares = shares;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public int getShares() {
		return this.shares;
	}

}
