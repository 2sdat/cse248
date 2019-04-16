
public class Demo {

	public static void main(String[] args) {
		Hero hero1 = new Hero();
		hero1.setAbility(new Level1());
		System.out.println("Hero level one!");
		hero1.act();
		System.out.println();
		
		hero1.setAbility(new Level2());
		System.out.println("Hero levelled up!");
		hero1.act();
		System.out.println();
		
		hero1.setAbility(new Level3());
		System.out.println("Hero levelled up!");
		hero1.act();
		System.out.println();
	}

}
