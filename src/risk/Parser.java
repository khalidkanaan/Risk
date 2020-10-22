package risk;

import java.util.Scanner;

public class Parser {

    Scanner inputScanner;

    public Parser() {
        inputScanner = new Scanner(System.in);
    }

    public Command getCommand() {
        System.out.print("Enter command: ");
        inputScanner.next();
        return new Command();
    }

    public String getInput(String message) {
        System.out.print(message);
        return inputScanner.next();
    }

    public int getInt(String message) {
        while (true) {
            try {
                System.out.print(message);

                return Integer.parseInt(inputScanner.next());
            } catch (Exception e) {
                System.out.println("That was not a number, now try again.");
            }
        }
    }
}
