
public interface Ringable {
	// your code here
	default String ring() {
		return ("This is a ringing sound.");
	
	}
	default String unlock() {
		return ("Your phone is now unlocked");
	}
}
