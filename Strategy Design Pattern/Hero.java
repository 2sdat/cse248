
public class Hero {
	private Ability ability;
	
	public void setAbility(Ability ability) {
		this.ability = ability;
	}
	
	public void travel() {
		ability.travel();
	}
	
	public void handleWeapons() {
		ability.handleWeapons();
	}
	
	public void protect() {
		ability.protect();
	}
	
	public void act() {
		travel();
		handleWeapons();
		protect();
	}
}
