import java.util.ArrayList;
import java.util.*;
public class BasicJava {
    public static void main(String[] args){

        // Print 1-255
        int a = 1;
        while(a < 256){
            System.out.println(a);
            a++;
        }

        // Print odd numbers between 1-255
        int b = 1;
        while(b < 256){
            if(b % 2 == 0){
                b++;
            }
            else{
                System.out.println(b);
                b++;
            }
        }

        // Print Sum
        int sumNumbers = 0;
        for(int c = 0; c < 256; c++){
            sumNumbers = sumNumbers + c;
            System.out.println("New number:" + c + "Sum:" + sumNumbers);
        }

        // Iterating through an array
        int[] x = {1,3,5,7,9,13};
        for(int d = 0;d < x.length; d++){
            System.out.println(x[d]);
        }

        // Find Max
        // int[] x = {1,3,5,7,9,13};
        int max = x[0];
        for(int e = 0; e < x.length; e++){
            if(max < x[e]){
                max = x[e];
            }
        }
        System.out.println(max);

        // Get Average
        // int[] x = {1,3,5,7,9,13};
        float avg = x[0];
        int f = 0;
        while(f < x.length){
            avg = avg + x[f];
            f++;
        }
        avg = avg / x.length;
        System.out.println(avg);

        // Array with odd numbers
        ArrayList<Integer> y = new ArrayList<Integer>();
        int g = 0;
        while(g < 256){
            if(g % 2 == 0){
                g++;
            }
            else{
                y.add(g);
                g++;
            }
        }
        System.out.println(y);

        // Greater than Y
        int [] array = {1, 3, 5, 7};
        int greaterY = 3;
        int numGreater = 0;
        for(int h = 0;h < array.length; h++){
            if(greaterY < array[h]){
                numGreater++;
            }
        }
        System.out.println(numGreater);

        // square the values
        int [] sqArray = {1, 5, 10, -2};
        int j = 0;
        while(j < sqArray.length){
            sqArray[j] = sqArray[j] * sqArray[j];
            j++;
        }

        System.out.println(Arrays.toString(sqArray));

        // eliminate the negative numbers
        int [] noNeg = {1, 5, 10, -2};
        int k = 0;
        while(k < noNeg.length){
            if(noNeg[k] < 0){
                noNeg[k] = 0;
                k++;
            }
            else{
                k++;
            }
        }
        System.out.println(Arrays.toString(noNeg));

        // min max average
        int [] mmaArray = {1, 5, 10, -2};
        ArrayList<Integer> minMaxAvg = new ArrayList<Integer>();
        int mMax = mmaArray[0];
        int mMin = mmaArray[0];
        int mAvg = mmaArray[0];
        int n = 0;
        for(int m = 0; m < 4; m++){
            if(mMax < mmaArray[m]){
                mMax = mmaArray[m];
            }
            if(mMin > mmaArray[m]){
                mMin = mmaArray[m];
            }
        }
        while(n < mmaArray.length){
            mAvg = mAvg + mmaArray[n];
            n++;
        }
        mAvg = mAvg / mmaArray.length;
        minMaxAvg.add(mMax);
        minMaxAvg.add(mMin);
        minMaxAvg.add(mAvg);
        System.out.println(minMaxAvg);

        // shifting the values of an array one forward
        int[] shiftArray = {1, 5, 10, 7, -2};
        for(int p = 1; p < shiftArray.length; p++) {
            shiftArray[p-1] = shiftArray[p];
        }
        shiftArray[shiftArray.length-1] = 0;
        System.out.println(Arrays.toString(shiftArray));
    }        
}