package decorator_v2;

public class Demo {
	public static void main(String[] args) {
		System.out.println("Decorator Pattern v2");
		
		Converter c1 = new Converter();
		System.out.println(c1.letsConvertToCelsius(32));
		
		TempWrapper tempWrapper = new TempWrapper(c1);
		System.out.println(tempWrapper.letsConvertToCelsius(212));
		System.out.println(tempWrapper.letsConvertToFahrenheit(0));
	}
}
