package com.twu.biblioteca;

import org.junit.Test;
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MenuTest {
    Menu menu = new Menu();

    @Test
    public void getOptionsShouldReturnMenuOptions() {
        ArrayList<String> options = menu.getOptions();

        assertThat(options.get(0), equalTo("0. Quit"));
        assertThat(options.get(1), equalTo("1. List of books"));
    }

    @Test
    public void printOptionsShouldPrintMenuOptions() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        menu.printOptions();

        assertThat(output.toString(), containsString("Please select an option."));
        assertThat(output.toString(), containsString("List of books"));
    }
}
