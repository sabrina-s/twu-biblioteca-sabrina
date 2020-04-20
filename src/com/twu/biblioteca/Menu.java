package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends Printer {
    private ArrayList<String> menuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<String>(Arrays.asList(
                "0. Quit",
                "1. List of books",
                "2. Checkout book",
                "3. Return book",
                "4. List of movies"
        ));
    }

    public void printOptions() {
        System.out.println("Please select an option.");
        for(int i = 0; i < menuOptions.size(); i++) {
            System.out.println(menuOptions.get(i));
        }
        System.out.println("");
    }
}
