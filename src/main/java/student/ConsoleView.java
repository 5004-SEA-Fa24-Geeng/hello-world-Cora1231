package student;

import java.util.Scanner;
import java.util.List;

/**
 * ConsoleView is a class used to handle all input/output from the console.
 */
public final class ConsoleView {

    /**
     * A single, shared Scanner for reading user input.
     */
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Cache a copy of the locality options from Greeter, so we only fetch once.
     */
    private static final List<String> LOCALITY_OPTIONS = Greeter.getLocalityList();

    /**
     * Private constructor to prevent instantiation.
     */
    private ConsoleView() {
        // No-op
    }

    /**
     * Prompt the user for their name.
     *
     * @return the entered name
     */
    public static String getName() {
        System.out.print("Welcome, what is your name? ");
        return SCANNER.nextLine().trim();
    }

    /**
     * Prompt the user to select a locality by number. If they select an invalid
     * number, it keeps prompting until they choose a valid one.
     *
     * @return a valid locality index (1-based)
     */
    public static int getLocality() {
        System.out.println("Select a locality:");
        for (int i = 0; i < LOCALITY_OPTIONS.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + LOCALITY_OPTIONS.get(i));
        }
        System.out.print("> ");
        String input = SCANNER.nextLine().trim();

        try {
            int choice = Integer.parseInt(input);
            if (choice < 1 || choice > LOCALITY_OPTIONS.size()) {
                System.out.println("Invalid choice. Please try again.");
                return getLocality();
            }
            return choice;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input (numbers only). Please try again.");
            return getLocality();
        }
    }

    /**
     * Ask the user if they want to continue being greeted. Acceptable inputs:
     * "yes"/"y" or "no"/"n". If invalid, it keeps prompting.
     *
     * @return true if user says yes, false otherwise
     */
    public static boolean checkRunAgain() {
        System.out.print("Would you like to be greeted again (yes/no)? ");
        String input = SCANNER.nextLine().trim().toLowerCase();

        if (input.equals("yes") || input.equals("y")) {
            return true;
        } else if (input.equals("no") || input.equals("n")) {
            return false;
        } else {
            System.out.println("Invalid answer, please try again.");
            return checkRunAgain();
        }
    }

    /**
     * Prints the greeting text to the console.
     *
     * @param greeting the text to be printed
     */
    public static void printGreeting(String greeting) {
        System.out.println(greeting);
    }
}
