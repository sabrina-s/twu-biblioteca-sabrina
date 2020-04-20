package com.twu.biblioteca;
import static com.twu.biblioteca.Constants.VALID_MENU_INPUTS;

import java.util.Scanner;

public class InputReader {
    private String input;
    private String type;
    private Scanner scanner = new Scanner(System.in);

    public InputReader(String type) {
        this.type = type;
    }

    public void run() {
        printInstructions();
        processInput();
    }

    private void printInstructions() {
        if (type.equals("menu")) {
            System.out.print("Enter option number: ");
        } else if (type.equals("book")) {
            System.out.print("Enter title of book: ");
        } else if (type.equals("movie")) {
            System.out.print("Enter name of movie: ");
        }
    }

    private String processInput() {
        input = scanner.nextLine();
        boolean valid = validateInput(input);

        while (!valid) {
            input = scanner.nextLine();
            valid = validateInput(input);
        }

        return input;
    }

    public String getInput() {
        return input;
    }

    private boolean validateInput(String input) {
        if (type.equals("menu") && VALID_MENU_INPUTS.contains(input)) {
            return true;
        } else if (type.matches("book|movie")) {
            return true;
        } else {
            System.out.println("Please select a valid option!");
            System.out.print("Enter option number: ");
            return false;
        }
    }
}
