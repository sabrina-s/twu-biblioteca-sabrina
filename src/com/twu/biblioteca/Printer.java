package com.twu.biblioteca;

public class Printer implements IPrinter {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
