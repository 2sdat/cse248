package lazy_initialization;

public class Instructor {
	private static String name;
	private static Instructor _instructor;
	
	private Instructor(String name) { Instructor.name = name; }
	
	public static Instructor makeTheInstructor(String name) {
		if (_instructor == null ) {
			_instructor = new Instructor(name);
		}
		
		_instructor.setName(name);
		return _instructor;
	}
	
	public String getName() {
		return Instructor.name;
	}
	
	public void setName(String name) {
		Instructor.name = name;
	}
	
	public String toString() {
		return "Instructor [name = " + name + " ]"];
	}
}
