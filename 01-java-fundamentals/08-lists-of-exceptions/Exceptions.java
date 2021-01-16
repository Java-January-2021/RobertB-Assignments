import java.util.*;
public class Exceptions {
    public static void main(String[] args) {
        System.out.println("hello world");

        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        System.out.println(myList);

        for(int i = 0; i < myList.size(); i++) {
        try {
            Integer castedValue = (Integer) myList.get(i);
            System.out.println("This one Worked: " + castedValue);
        }
        catch (Exception error) {
            System.out.println("Index of the object: " + myList.indexOf(myList.get(i)));
            System.out.println("Value of the object: " + myList.get(i));
            System.out.println(error);
        }
        }
        System.out.println("were still here");
    }
}