package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrinterTest {
    String message = "Hello world!";
    Printer printer = new Printer();

    @Test
    public void printsMessage() {
        assertEquals(message, printer.print(message));
    }
}
