package itshackney;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;
import java.util.function.Consumer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by ellioe03 on 01/02/2017.
 */



@RunWith(MockitoJUnitRunner.class)
public class MainTest {

    @Test
    public void itReturnsSortedArray() throws Exception {

        arraySorter underTest = new arraySorter();

        int[] ary = new int[]{106, 26, 81, 5, 15};
        int[] expected = new int[]{106, 81, 26, 15, 5};

        assertThat(underTest.sortIntegers(ary), is(expected));
    }

    @Test
    public void itTakesInputFromKeyboardAndOutputsArray() throws Exception {
        arraySorter underTest = new arraySorter();

        StringWriter output = new StringWriter();

        Consumer<String> outputStringln = str -> {
            PrintWriter printOutput = new PrintWriter(output);
            printOutput.println(str);
        };


        String input = "5\n"
                    +"106\n"
                    + "26\n"
                    + "81\n"
                    + "5\n"
                    + "15\n";

        assertThat(underTest.getIntegers(new Scanner(input),outputStringln),is(new int[]{106, 26, 81, 5, 15}));
        assertThat(output.toString(),is("How many numbers do you want to sort?\r\n" +
                "Input entry number 0:\r\n" +
                "Input entry number 1:\r\n" +
                "Input entry number 2:\r\n" +
                "Input entry number 3:\r\n" +
                "Input entry number 4:\r\n"));
    }

    @Test
    public void itPrintsOutContentsOfTheArray() throws Exception {

        arraySorter underTest = new arraySorter();

        int[] ary = new int[]{106, 81, 26, 15, 5};


        StringWriter output = new StringWriter();

        Consumer<String> outputPrint = str -> {
            PrintWriter outputWriter = new PrintWriter(output);
            outputWriter.print(str);
        };

        underTest.printArray(ary,outputPrint);

        System.out.print(output.toString());
        assertThat(output.toString(),is("[106, 81, 26, 15, 5]\n"));
    }
}


