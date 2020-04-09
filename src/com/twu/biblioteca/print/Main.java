package com.twu.biblioteca.print;

public class Main {
    public static void main(String[] args) {
        App app = new App(new RealPrinter());

        app.execute();
    }
}
