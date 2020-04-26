package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu extends Printer {
    private ArrayList<String> menuOptions;
    private ArrayList<String> restrictedMenuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<String>(Arrays.asList(
                "[q] Quit",
                "[li] Login",
                "[lob] List of books",
                "[lom] List of movies"
        ));
        this.restrictedMenuOptions = new ArrayList<>(Arrays.asList(
                "[q] Quit",
                "[pro] Profile",
                "[lob] List of books",
                "[lom] List of movies",
                "[cob] Checkout book",
                "[com] Checkout movie",
                "[rb] Return book",
                "[inv] Show inventory"
        ));
    }

    public void printOptions() {
        print("Please enter option (e.g. 'lob')");
        for(int i = 0; i < menuOptions.size(); i++) {
            print(menuOptions.get(i));
        }
        print("");
    }

    public void printRestrictedOptions() {
        print("Please enter option (e.g. 'cob')");
        for(int i = 0; i < restrictedMenuOptions.size(); i++) {
            print(restrictedMenuOptions.get(i));
        }
        print("");
    }
}
