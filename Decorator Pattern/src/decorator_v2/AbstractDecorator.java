package decorator_v2;

public abstract class AbstractDecorator{
	
	private Converter converter;
	
	public AbstractDecorator(Converter converter) {
		this.converter = converter;
	}

	public double letsConvertToCelsius( double temp ) {
		return converter.letsConvertToCelsius(temp);
	}
	
	public abstract double letsConvertToFahrenheit(double tmep);

}
