
public class Human {
	public String name;
	private int strength = 3;
	private int stealth = 3;
	private int intelligence = 3;
	private int health = 100;
	int count = 0;
	
	public int getStrength() {
		return this.strength;
	}
	public int getStealth() {
		return this.stealth;
	}
	public int getIntelligence() {
		return this.intelligence;
	}
	public int getHealth() {
		return this.health;
	}
	public void setStrength(int strength) {
		this.strength = strength;
	}
	public void setStealth(int stealth) {
		this.stealth = stealth;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public void attack(Human target) {
		int otherHealth = target.getHealth();
		target.setHealth(otherHealth -= this.strength);
		System.out.println(target.getHealth());
	}
	public int count() {
		return count;
	}

}
