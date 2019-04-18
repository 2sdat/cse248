package facade_pattern;

public class Demo {
	public static void main(String[] args) {
		RobotFacade robot = new RobotFacade();
		robot.constructRobot("Orange", "Titanium");
		robot.constructRobot("Green", "Iron");
	}
}
