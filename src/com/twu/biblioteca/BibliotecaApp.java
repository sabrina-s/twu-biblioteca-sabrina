package com.twu.biblioteca;

public class BibliotecaApp {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private final Printer printer;

    public BibliotecaApp(Printer printer) {
        this.printer = printer;
    }

    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print(WELCOME_MESSAGE);
    }
}
