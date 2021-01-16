import java.util.*;
public class PuzzleJavaTest {
    public static void main(String[] args) {
        PuzzleJava methods = new PuzzleJava();

        System.out.println("sum and greater than 10");
        int[] sumMaxArray = {3,5,1,2,7,9,8,13,25,32};
        ArrayList<Integer> maxVals = new ArrayList<Integer>();
        int max = 10;
        methods.sumMax(sumMaxArray,maxVals,max);
        System.out.println("Values > "+max+":" +maxVals);

        System.out.println("Name Array Shuffle");
        String[] nameArray = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> namesList = new ArrayList<String>();
        ArrayList<String> largeNames = new ArrayList<String>();
        int charMax = 5;
        methods.nameArray(nameArray, namesList, largeNames, charMax);
        System.out.println("Names greater then " + charMax + " are " + largeNames);

        System.out.println("alphabet");
        ArrayList<Character> alphabet = new ArrayList<Character>();
        methods.alph(alphabet);

        System.out.println("55 - 100");
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        methods.nums(numbers);

        System.out.println("random character string");
        ArrayList<Character> chars = new ArrayList<Character>();
        methods.randChars(chars);

    }
    
}