package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp(new Printer(), new Library());

        app.execute();
    }
}
