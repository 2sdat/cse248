package Stocks;

public class StockBag {
	private Stock[] stockArr;
	private int nElems;
	
	public StockBag(int maxSize) {
		stockArr = new Stock[maxSize];
		nElems = 0;
	}
	
	public double getGrandTotal() {
		double grandTotal = 0.0;
		for(int i = 0; i < nElems; i++) {
			grandTotal += stockArr[i].getPrice()*stockArr[i].getShares();
		}
		return grandTotal;
	}
}
