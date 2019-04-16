package pugh_singleton;

public class Demo {

	public static void main(String[] args) {
		Instructor i1 = Instructor.makeTheInstructor();
		Instructor.setName("John");
		System.out.println(Instructor.getName());
		Instructor i2 = Instructor.makeTheInstructor();
		Instructor.setName("Joe");
		System.out.println(Instructor.getName());
		System.out.println();
		System.out.println(i1 == i2);
	}
}
