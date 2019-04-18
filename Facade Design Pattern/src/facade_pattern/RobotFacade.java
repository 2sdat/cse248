package facade_pattern;

public class RobotFacade {
	private RobotColor rc;
	private RobotMetal rm;
	private RobotBody rb;
	
	public RobotFacade() {
		rc = new RobotColor();
		rm = new RobotMetal();
		rb = new RobotBody();
	}
	
	public void constructRobot(String color, String metal) {
		System.out.println("Starting robot creation...");
		rm.setMetal(metal);
		rc.setColor(color);
		rb.createBody();
	}
}
