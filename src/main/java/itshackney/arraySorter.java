package itshackney;

import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by ellioe03 on 01/02/2017.
 */
@SuppressWarnings("ALL")
public class arraySorter {

    public int[] getIntegers() {
        return getIntegers(new Scanner(System.in), str -> System.out.println(str));
    }

    public int[] getIntegers(Scanner scanner, Consumer<String> outputStringln){
        outputStringln.accept("How many numbers do you want to sort?\r");
        int numberOfEntries = scanner.nextInt();
        int[] ary = new int[numberOfEntries];
        for(int i=0;i<numberOfEntries;i++) {
            outputStringln.accept("Input entry number " + i + ":\r");
            ary[i] = scanner.nextInt();
        }
        return ary;
    }


    public int[] sortIntegers(int[] array) {
        int[] ary = array.clone();
        boolean isSwap;
        do {
            isSwap = false;
            for (int i = 0; i < ary.length - 1; i++) {
                int firstItem = ary[i];
                int secondItem = ary[i + 1];
                if (secondItem > firstItem) {
                    isSwap = true;
                    ary[i] = secondItem;
                    ary[i + 1] = firstItem;
                }
            }
        }
        while (isSwap);
        return ary;
    }


    public void printArray(int[] ary) {
        printArray(ary,str -> System.out.print(str));
    }

    public void printArray(int[] ary, Consumer<String> outputString) {
        int length = ary.length;
        outputString.accept("[");
        for (int i = 0; i < length; i++) {
            outputString.accept(String.valueOf(ary[i]));
            if (i < length - 1) outputString.accept(", ");
        }
        outputString.accept("]\n");
    }

}
