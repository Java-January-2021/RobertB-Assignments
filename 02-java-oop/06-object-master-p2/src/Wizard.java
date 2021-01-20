
public class Wizard extends Human {
	String name;
	int wizHealth = 50;
	int wizIntelligence = 8;
	
	public Wizard(String name) {
		this.name = name;
		this.health = wizHealth;
		this.intelligence = wizIntelligence;
		
	}
	public void heal(Human target) {
		target.health += this.intelligence;		
		System.out.println(target.health);
	}
	public void fireball(Human target) {
		target.health -= this.intelligence * 3;
		System.out.println(target.health);
	}
}
