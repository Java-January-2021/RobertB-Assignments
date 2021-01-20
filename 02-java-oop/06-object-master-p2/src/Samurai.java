
public class Samurai extends Human {
	String name;
	int samHealth = 200;
	static int count = 0;
	
	public Samurai(String name) {
		this.name = name;
		this.health	= samHealth;
		count += 1;
	}
	public void deathBlow(Human target) {
		target.health = 0;
		this.health = this.health / 2;
		System.out.println(this.health);
		System.out.println(target.health);
	}
	public void meditate() {
		this.health += this.health / 2;
		System.out.println(this.health);
	}
	public static void howMany() {
		System.out.println(count);
	}
}
