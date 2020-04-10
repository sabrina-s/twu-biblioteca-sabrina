package com.twu.biblioteca;

public class BibliotecaApp {
    public static final String WELCOME_MESSAGE = "Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!\n";
    private IPrinter printer;
    private Library library;
    private Menu menu;

    public BibliotecaApp(IPrinter printer, Library library, Menu menu) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
    }

    public void execute() {
//        print welcome message
        printer.print(WELCOME_MESSAGE);

//        populate library with books
        Book book1 = new Book("Book1", "Author1", 2001);
        Book book2 = new Book("Book2", "Author2", 2002);
        Book book3 = new Book("Book3", "Author3", 2003);
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

//        display menu
        menu.printOptions();

//        print a list of all books
//        library.printBooks();
    }
}
