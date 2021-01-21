
public class Galaxy extends Phone implements Ringable {
	 public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
	        super(versionNumber, batteryPercentage, carrier, ringTone);
	    }
	    @Override
	    public String ring() {
	        return this.getRingTone();	
	    }
	    @Override
	    public String unlock() {
	        // your code here
	    	return ("Unlocking via finger print");
	    }
	    @Override
	    public void displayInfo() {
	    	System.out.println("Version Number: " + this.getVersionNumber());
	        System.out.println("Battery percentage: " + this.getBatteryPercentage());
	        System.out.println("Carrier: " + this.getCarrier());
	        System.out.println("RingTone: " + this.getRingTone());            
	    }
}
