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
    public void printOptionsShouldPrintMenuOptions() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        menu.printOptions();

        assertThat(output.toString(),
                both(containsString("Please select an option.")).
                and(containsString("Quit")).
                and(containsString("List of books")).
                and(containsString("Checkout book")));
    }
}
