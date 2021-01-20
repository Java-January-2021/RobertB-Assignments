
public class Gorilla extends Mammal {
	public String throwSomething(String name) {
		System.out.println("The Gorilla has thrown " + name + " at you");
		this.energyLevel = energyLevel - 5;
		System.out.println("The Gorilla's new energy level is " + energyLevel);
		return ("");
	}
	public void eatBananas() {
		System.out.println("The Gorilla is pleased with your offering");
		this.energyLevel = energyLevel + 10;
		System.out.println("The Gorilla's new energy level is " + energyLevel);
	}
	public void climb() {
		System.out.println("The Gorilla has found a nice sturdy tree to climb ");
		this.energyLevel = energyLevel - 10;
		System.out.println("The Gorilla's new energy level is " + energyLevel);
	}
}