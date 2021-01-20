
public class Ninja extends Human {
	String name;
	int ninStealth = 10;
	
	public Ninja(String name) {
		this.name = name;
		this.stealth = ninStealth;
	}
	public void steal(Human target) {
		target.health -= this.stealth;
		this.health += this.stealth;
		System.out.println(target.health);
		System.out.println(this.health);
	}
	public void runAway() {
		this.health -= 10;
		System.out.println(this.health);
	}
	
}
