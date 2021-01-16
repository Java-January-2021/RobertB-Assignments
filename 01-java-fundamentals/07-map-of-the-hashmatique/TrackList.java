import java.util.*;
public class TrackList{
    public static void main(String[] args) {

        HashMap<String, String> tracks = new HashMap<String, String>();
        tracks.put("Worldwide Choppers", "We started in the Midwest Now we 'bout to take it all over the world, baby This is the pinnacle, yeah, Tech N9ne");
        tracks.put("Am I a Psycho?", "You’re crazy! I like you, but you’re crazy My tours paid me, so I used that dough to allure ladies To manure bathe me Never that, my mind's for sure shady Pure Hades, Rev X said that he couldn’t endure to save me Why do I let this stripper burn me on my arm with a cigarette in the same spot ten times in a row?");
        tracks.put("Fragile", "You said you'd never ever break... down But here I am sweeping... pieces off of the ground You said you'd never, ever play... to crowds But I've seen you hoping to play songs to them now I've spent all night long scared of tomorrow, I broke my alarm Everything is almost lost, pick it up slow, before it's gone...");
        tracks.put("Caribou Lou", "Half a bottle of 151 off in a jug 1 cup of Malibu Rum, baby that's whassup then you Fill the rest of the jug with pineapple juice and it's crackin' The only defect is waking up like what happened");

        String worldWideChoppers = tracks.get("Worldwide Choppers");
        System.out.println(worldWideChoppers);
        
        Set<String> keys = tracks.keySet();
        for(String key: keys){
            System.out.println(key);
            System.out.println(tracks.get(key));
        }
    }
}