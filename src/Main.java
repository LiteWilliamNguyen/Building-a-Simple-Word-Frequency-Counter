import java.util.*;

public class Main {
    public static void main(String[] args){
        //Write a Java program that prompts the user to enter a block of text.
        //Develop a Java program that reads a text input from the user and calculates the frequency of each word in the text using a HashMap.

        //You can use Scanner class to read the input from the console.
        Scanner scanner = new Scanner(System.in);
        //Create a HashMap where the keys are words, and the values are the counts of each word.
        HashMap<String, Integer> wordFrequency = new HashMap<>();

        //Print prompt to read multiple line until types "exit"
        System.out.println("Enter Text, and type 'exit' to finish");
        // Read multiple lines until user types "exit"
        while (true) {
            String line = scanner.nextLine();
            if (line.equalsIgnoreCase("exit")) {
                break;
            }
        scanner.close();
    }
}
}
