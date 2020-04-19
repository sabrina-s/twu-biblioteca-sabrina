package com.twu.biblioteca;

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Library library = new Library();
        Menu menu = new Menu();

        // populate library with books
        library.addBook(new Book("Book1", "Author1", 2001));
        library.addBook(new Book("Book2", "Author2", 2002));
        library.addBook(new Book("Book3", "Author3", 2003));

        // populate library with movies
        library.addMovie(new Movie("Movie1", "Director1", 2001, 8));
        library.addMovie(new Movie("Movie2", "Director2", 2002, 6));
        library.addMovie(new Movie("Movie2", "Director3", 2002));

        BibliotecaApp app = new BibliotecaApp(
                printer, library, menu
        );

        boolean active = app.execute();

        while (active) {
            active = app.execute();
        }
    }
}
