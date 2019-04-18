
public class Converter implements ITemp{

	@Override
	public double letsConvertToCelsius(double temp) {
		return 5*(temp-32)/9;
	}
	
}
