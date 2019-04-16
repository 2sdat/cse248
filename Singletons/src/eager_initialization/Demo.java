package eager_initialization;

public class Demo {

	public static void main(String[] args) {
		Instructor i1 = Instructor.makeTheInstructor("John");
		Instructor i2 = Instructor.makeTheInstructor("Joe");
		System.out.println(i1 == i2);
	}

}
