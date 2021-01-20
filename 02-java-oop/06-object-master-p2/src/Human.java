
public class Human {
	int strength = 3;
	int stealth = 3;
	int intelligence = 3;
	int health = 100;
	
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
	public void attack(Human jake) {
		int otherHealth = jake.getHealth();
		jake.setHealth(otherHealth -= this.strength);
		System.out.println(jake.getHealth());
	}

}
