package decorator_v2;

public class TempWrapper extends AbstractDecorator {
	
	public TempWrapper(Converter converter) {
		super(converter);
	}
	
	@Override
	public double letsConvertToFahrenheit(double temp) {
		return (9*temp/5) + 32;
	}

}
