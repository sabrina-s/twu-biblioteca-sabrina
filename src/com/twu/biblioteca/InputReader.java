package com.twu.biblioteca;
import static com.twu.biblioteca.Constants.VALID_INPUTS;

import java.util.Scanner;

public class InputReader {
    private static String input;

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter option number: ");

        input = scanner.nextLine();

        while (!VALID_INPUTS.contains(input)) {
            System.out.println("Please select a valid option!");
            System.out.print("Enter option number: ");
            input = scanner.nextLine();
        }

        return input;
    }
}
