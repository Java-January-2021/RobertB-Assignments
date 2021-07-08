
public class HumanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human jake = new Human();
		Human rob = new Human();
		Wizard lee = new Wizard("Lee");
		
		rob.attack(jake);
		System.out.println(jake.getHealth());
		
	}

}
