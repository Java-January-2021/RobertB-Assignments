import java.util.*;
public class PuzzleJava{
    // sum and max array
    public ArrayList<Integer> sumMax(int[] input, ArrayList<Integer> maxVals, int max){
        int sum = 0;
        for(int i = 0; i < input.length; i++){
            sum += i;
            if(input[i] > max){
                maxVals.add(input[i]);
            }
        }
        System.out.println("Total: "+sum);
        return maxVals;
    }
    public ArrayList<String> nameArray(String[] nameArray, ArrayList<String> namesList, ArrayList<String> largeNames, int charMax){
        for(int i = 0; i < nameArray.length; i++){
            namesList.add(nameArray[i]);
            String temp = nameArray[i];
            int max = temp.length();
            if( max > charMax){
                largeNames.add(nameArray[i]);
            }
        }
        Collections.shuffle(namesList);
        System.out.println("shuffled names: " + namesList);
        return largeNames;

    } 
    public ArrayList<Character> alph(ArrayList<Character> alphabet){
        for(char ch = 'a'; ch <= 'z'; ++ch){
            alphabet.add(ch);
        }
        Collections.shuffle(alphabet);
        System.out.println(alphabet);
        char first = alphabet.get(0);
        System.out.println(first);
        System.out.println(alphabet.get(25));
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        for(int i = 0;i < vowel.length; i++){
            if(first == vowel[i]){
                System.out.println("the first letter is a vowel");
            }
        }
        return alphabet;
    }
    public ArrayList<Integer> nums(ArrayList<Integer> numbers){
        int i = 55;
        while(i < 101){
            numbers.add(i);
            i++;
        }
        ArrayList<Integer> tenNumbers = new ArrayList<Integer>();
        Random rand = new Random();
        int x = 0;
        while(x < 10){
            int randNum = rand.nextInt(45);
            tenNumbers.add(numbers.get(randNum));
            x++;
        }
        // for(int x = 1;x < 11; x++){
        //     tenNumbers.add(numbers.get(randNum));
        // }
        System.out.println(numbers);
        System.out.println(tenNumbers);
        System.out.println("Random 10 numbers sorted, maximum inside of array, and minimum inside of array");
        Collections.sort(tenNumbers);
        System.out.println(tenNumbers);
        int max = tenNumbers.get(1);
        int min = tenNumbers.get(1);
        for(int r = 0; r < tenNumbers.size(); r++){
            if(max < tenNumbers.get(r)){
                max = tenNumbers.get(r);
            }
            if(min > tenNumbers.get(r)){
                min = tenNumbers.get(r);
            }
        }
        System.out.println(max);
        System.out.println(min);
        return numbers;

    }
    public ArrayList<Character> randChars(ArrayList<Character> chars){
        Random randChars = new Random();
        StringBuilder strBuild = new StringBuilder();
        ArrayList<String> tenStrings = new ArrayList<String>();
        String m = "string";
        for(char ch = 'a'; ch <= 'z'; ++ch){
            chars.add(ch);
        }
        Collections.shuffle(chars);
        // System.out.println(chars);
        int e = 0;
        for(int i = 0; i < 5; i++){
            strBuild.append(chars.get(i));
            m = strBuild.toString();
        }
        tenStrings.add(m);
        e++;
        System.out.println(m);
        System.out.println(tenStrings);



        return chars;
    }

}