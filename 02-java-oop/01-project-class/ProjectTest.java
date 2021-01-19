public class ProjectTest{
    public static void main(String[] args){
        Project elevator = new Project();
        elevator.setTheName("HellEvator");
        elevator.setTheDescription("Tech N9ne's elevator");
        String elevatorName = elevator.getTheName();
        String elevatorDescription = elevator.getTheDescription();
        System.out.println(elevator.elevatorPitch());
        // System.out.println("Elevator name is " + elevatorName + " the elevator is actually " + elevatorDescription);
    }
}