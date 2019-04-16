
public class Level3 implements Ability{

	@Override
	public void travel() {
		System.out.println("Level3: Travel on car.");
	}

	@Override
	public void handleWeapons() {
		System.out.println("Level3: Fight with gun.");
	}

	@Override
	public void protect() {
		System.out.println("Level3: Wear armor.");
	}
	
}
