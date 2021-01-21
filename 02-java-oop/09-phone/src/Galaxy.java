
public class Galaxy extends Phone implements Ringable {
	 public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
	        super(versionNumber, batteryPercentage, carrier, ringTone);
	    }
	    @Override
	    public String ring() {
	        return ("Galaxy s9 says Ring Ring Ring!");	
	    }
	    @Override
	    public String unlock() {
	        // your code here
	    	return ("Unlocking via finger print");
	    }
	    @Override
	    public void displayInfo() {
	        System.out.println("Galaxy s9 from Verizon");            
	    }
}
