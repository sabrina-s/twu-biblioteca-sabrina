package com.twu.biblioteca.print;

public class RealPrinter implements IPrinter{

    @Override
    public void println(String message) {
        System.out.println(message);
    }
}
