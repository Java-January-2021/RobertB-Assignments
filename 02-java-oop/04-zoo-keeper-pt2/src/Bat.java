
public class Bat extends Mammal {
	int energyLevel = 300;
	public void fly() {
		System.out.println("Houston clear the runway the bat is taking off. Copy. runway is clear. Bat is good for take off *WOOSH* *SCREEEEEECH* *Sound of bat taking off* ");
		energyLevel = energyLevel - 50;
		System.out.println(energyLevel);
	}
	public String eatHumans(String name) {
		System.out.println("You hear the slurping of blood and look over to see " + name + " pale and lifeless, looking as if the blood was drained from their body. You hesitate for a moment and think to yourself. Im fine the bat just ate and isn't hungry anymore. You turn around and go about your bussiness.");
		energyLevel = energyLevel + 25;
		System.out.println(energyLevel);
		return ("");
	}
	public String attackTown(String townName) {
		System.out.println("The bat decided to attack  " + townName + " With all the chaos all you hear is people screaming and while the city is on fire.");
		energyLevel = energyLevel - 100;
		System.out.println(energyLevel);
		return("");
		
	}
}
