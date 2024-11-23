import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    private void provideInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
    private String getOutput(){
        return outputStream.toString().trim();
    }

    // normal case
    //testing simple input to check if it is running correctly
    @Test
    void standardInput() {
        provideInput("Hello world! This is a test. Hello again.\nexit\n");
        Main.main(new String[]{});
        String expected = """
                Word Frequency:
                a: 1
                again: 1
                hello: 2
                is: 1
                test: 1
                this: 1
                world: 1
                """.trim();
        assertEquals(expected, getOutput());
    }
    //testing if case and punctuation work and ignored
    @Test
    void mixedCaseAndPunctuation() {
        provideInput("Java is fun. Java, Java, and more Java!\nexit\n");
        Main.main(new String[]{});
        String expected = """
                Word Frequency:
                and: 1
                fun: 1
                is: 1
                java: 4
                more: 1
                """.trim();
        assertEquals(expected, getOutput());
    }
    //testing multiple line input
    @Test
    void multiLineInput() {
        provideInput("Line one.\nLine two, two.\nLine three, three, three.\nexit\n");
        Main.main(new String[]{});
        String expected = """
                Word Frequency:
                line: 3
                one: 1
                three: 3
                two: 2
                """.trim();
        assertEquals(expected, getOutput());
    }
    //edge case
    //testing when no input other than exit
    @Test
    void emptyInput() {
        provideInput("exit\n");
        Main.main(new String[]{});
        String expected = "Word Frequency:";
        assertEquals(expected, getOutput());
    }
    //testing single word that is repeated
    @Test
    void singleWordRepeated() {
        provideInput("test test test test test\nexit\n");
        Main.main(new String[]{});
        String expected = """
                Word Frequency:
                test: 5
                """.trim();
        assertEquals(expected, getOutput());
    }
    //testing if only punctuation would be count or not.
    @Test
    void onlyPunctuation() {
        provideInput("!!! ??? ,,, ... ;;; :::\nexit\n");
        Main.main(new String[]{});
        String expected = "Word Frequency:";
        assertEquals(expected, getOutput());
    }
}