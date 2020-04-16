package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class PrinterTest {
    private PrintStream systemOut = System.out;
    private ByteArrayOutputStream output;

    Printer printer = new Printer();

    @Before
    public void setup() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void reset() {
        System.setOut(systemOut);
    }

    @Test
    public void printWillPrintMessage() {
        String message = "Hello world!";

        printer.print(message);

        assertThat(output.toString(), containsString("Hello world!"));
    }
}
