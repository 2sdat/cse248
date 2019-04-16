package pugh_singleton;

public class Instructor {
	private static String name;
	private static Instructor _instructor;
	
	private Instructor() {}
	
	private static class SingletonHelper {
		private static final Instructor _instructor = new Instructor();
	}
	
	public static Instructor makeTheInstructor() {
		return SingletonHelper._instructor;
	}
	
	public static String getName() { return name; }
	public static void setName(String name) { Instructor.name = name; }
}
