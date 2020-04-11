package com.twu.biblioteca;

import java.util.Scanner;

public class InputReader {
    private static String input;

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter option number: ");

        input = scanner.nextLine();
        scanner.close();

        return input;
    }
}
