package itshackney;

/**
 * Array Challenge 2
 *
 */




public class Main
{
    public static void main( String[] args ) {
        arraySorter sorted = new arraySorter();
        int[] ary = sorted.getIntegers();
        int[] result = sorted.sortIntegers(ary);
        sorted.printArray(result);
    }
}
