
public class Level1 implements Ability{

	@Override
	public void travel() {
		System.out.println("Level1: Travel on foot.");
	}

	@Override
	public void handleWeapons() {
		System.out.println("Level1: Fight with fists");
	}

	@Override
	public void protect() {
		System.out.println("Level1: Wear T-shirt.");
	}

}
