package com.twu.biblioteca;

public class BibliotecaApp {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!";
    private IPrinter printer;

    public BibliotecaApp(IPrinter printer) {
        this.printer = printer;
    }

    public void execute() {
        printer.print(WELCOME_MESSAGE);
    }
}
