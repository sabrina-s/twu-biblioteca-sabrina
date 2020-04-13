package com.twu.biblioteca;
import static com.twu.biblioteca.Constants.VALID_INPUTS;

import java.util.Scanner;

public class InputReader {
    public String input;
    private String type;
    private Scanner scanner = new Scanner(System.in);

    public InputReader() {}

    public InputReader(String type) {
        this.type = type;
    }

    public void run() {
        printInstructions();
        getInput();
    }

    private void printInstructions() {
        if (type.equals("menu")) {
            System.out.print("Enter option number: ");
        }
    }

    public String getInput() {
        input = scanner.nextLine();
        boolean valid = validateInput(input);

        while (!valid) {
            input = scanner.nextLine();
            valid = validateInput(input);
        }

        return input;
    }

    private boolean validateInput(String input) {
        if (VALID_INPUTS.contains(input)) {
            return true;
        } else {
            System.out.println("Please select a valid option!");
            System.out.print("Enter option number: ");
            return false;
        }
    }
}
