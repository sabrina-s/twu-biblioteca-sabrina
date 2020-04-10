package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private ArrayList<String> menuOptions;

    public Menu() {
        this.menuOptions = new ArrayList<String>(Arrays.asList(
                "1. List of books"
        ));
    }

    public ArrayList<String> getOptions() {
        return menuOptions;
    }
}
