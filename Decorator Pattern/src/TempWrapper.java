
public class TempWrapper extends AbstractDecorator {
	public TempWrapper(ITemp itemp) {
		super(itemp);
	}
	
	@Override
	public double letsConvertToFahrenheit(double temp) {
		return (9*temp/5) + 32;
	}

}
