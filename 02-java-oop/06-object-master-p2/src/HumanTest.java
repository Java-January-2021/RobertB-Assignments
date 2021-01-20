
public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human jake = new Human();
		Human rob = new Human();
		Wizard lee = new Wizard("Lee");
		Ninja colby = new Ninja("Colby");
		Samurai jack = new Samurai("Jack");
		
		rob.attack(jake);
		lee.heal(jake);
		lee.fireball(jake);
		colby.steal(jake);
		colby.runAway();
		jack.deathBlow(rob);
		jack.meditate();
		Samurai.howMany();
	}

}
