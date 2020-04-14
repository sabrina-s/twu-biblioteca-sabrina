package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Library library = new Library();
        Menu menu = new Menu();
        InputReader inputReader = new InputReader();

        // populate library with books
        Book book1 = new Book("Book1", "Author1", 2001);
        Book book2 = new Book("Book2", "Author2", 2002);
        Book book3 = new Book("Book3", "Author3", 2003);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        BibliotecaApp app = new BibliotecaApp(
                printer, library, menu, inputReader
        );

        boolean active = app.execute();

        while (active) {
            active = app.execute();
        }
    }
}
