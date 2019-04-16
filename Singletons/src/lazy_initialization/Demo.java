package lazy_initialization;

public class Demo {

	public static void main(String[] args) {
		Instructor i1 = Instructor.makeTheInstructor("John");
		System.out.println(i1.getName());
		Instructor i2 = Instructor.makeTheInstructor("Joe");
		System.out.println(i2.getName());
		System.out.println(i1 == i2);
		System.out.println(i1.toString());
		System.out.println(i2.toString());
	}

}

