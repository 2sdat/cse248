
public abstract class AbstractDecorator implements ITemp {
	
	private ITemp itemp;
	
	public AbstractDecorator(ITemp itemp) {
		this.itemp = itemp;
	}
	
	@Override
	public double letsConvertToCelsius( double temp ) {
		return itemp.letsConvertToCelsius(temp);
	}
	
	public abstract double letsConvertToFahrenheit(double tmep);

}
