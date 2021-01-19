public class Project{
    private String theName;
    private String theDescription;

    public String getTheName(){
        return theName;
    }
    public void setTheName(String name){
        theName = name;
    }
    public String getTheDescription(){
        return theDescription;
    }
    public void setTheDescription(String description){
        theDescription = description;
    }

    public String elevatorPitch(){
        return ("the name is " +theName + " the desciption is" + theDescription);
    }
    public Project() {
    }
    public Project(String name) {
        this.theName = name;
        // return theName;
        // System.out.println(theName);
    }

    public Project(String name, String description) {
        this.theName = name;
        this.theDescription = description;
        // return theName + theDescription;
        // System.out.println(theDescription);
    }
}