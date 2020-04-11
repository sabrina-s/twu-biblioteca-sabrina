package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends Printer {
    private ArrayList<String> menuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<String>(Arrays.asList(
                "1. List of books"
        ));
    }

    public ArrayList<String> getOptions() {
        return menuOptions;
    }

    public void printOptions() {
        System.out.println("Please select an option.");
        for(int i = 0; i < menuOptions.size(); i++) {
            System.out.println(menuOptions.get(i));
        }
        System.out.println("");
    }
}
