package TemperatureConversion;

/**
 * @author Aidan Courtney - <A href="mailto:aidanfc97@gmail.com"> aidanfc97@gmail.com </A>
 * 
 * @see <A href="../applications/TemperatureConversion.java">Java source code </A>
 * 
 * @version v1.0, 2/19/2019
 * 
 */

public class TemperatureConversion {
	/**
	 * The main method prints a Celsius to Fernheit conversion table.
	 * The bounds of the table range from -50C to +50C in 10 degree increments.
	 * @param args not used
	 */
	public static void main(String[] args) {
		final double TABLE_BEGIN = -50.0;
		final double TABLE_END = 50.0;
		final double TABLE_STEP = 10.0;
		double celsius;
		double farenheit;
		System.out.println("TEMPERATURE CONVERSION");
		System.out.println("----------------------");
		System.out.println("Celsius      Farenheit");
		System.out.println("----------------------");
		for(celsius = TABLE_BEGIN; celsius <= TABLE_END; celsius += TABLE_STEP) {
			farenheit = celsiusToFarenheit(celsius);
			System.out.printf("%6.2fC", celsius);
			System.out.printf("%14.2fF\n", farenheit);
		}
		
		System.out.println("----------------------");
	}
	
	/**
	 * Convert a temperature from Celsius to Farenheit
	 * @param celsius temperature in degrees celsius
	 * @return temperature converted to farenheit
	 * @throws java.lang.IllegalArgumentException indicates that the Celsius temperature given is less than absolute zero
	 * @aidan.precondition celsius >= -273.16
	 * @aidan.postcondition the temperature in farenheit
	 */
	public static double celsiusToFarenheit(double celsius) {
		final double MINIMUM_CELSIUS = -273.16;
		if(celsius < MINIMUM_CELSIUS) {
			throw new IllegalArgumentException("Argument " + celsius + "is invalid.");
		}
		return (9.0 / 5.0) * celsius + 32;
	}

}
