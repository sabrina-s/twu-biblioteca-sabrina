package com.twu.biblioteca.print;

public class App {

    private IPrinter printer;

    public App(IPrinter printer) {
        this.printer = printer;
    }

    public void execute() {
        this.printer.println("my message");
    }
}
