
public class Level2 implements Ability{

	@Override
	public void travel() {
		System.out.println("Level2: Travel on bike.");
	}

	@Override
	public void handleWeapons() {
		System.out.println("Level2: Fight with knife.");
	}

	@Override
	public void protect() {
		System.out.println("Level2: Wear jacket.");
	}

}
