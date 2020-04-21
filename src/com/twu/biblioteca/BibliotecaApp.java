package com.twu.biblioteca;

import static com.twu.biblioteca.Constants.WELCOME_MESSAGE;

public class BibliotecaApp {
    private IPrinter printer;
    private Library library;
    private Menu menu;

    public BibliotecaApp(IPrinter printer, Library library, Menu menu) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
    }

    public boolean execute() {
//        print welcome message
        printer.print(WELCOME_MESSAGE);

//        display menu
        menu.printOptions();

//        get user menu input
        InputReader menuInputReader = new InputReader("menu");
        menuInputReader.run();
        String menuInput = menuInputReader.getInput();

//        perform action based on user input
        performAction(menuInput);

        return !menuInput.equals("0");
    }

    private void performAction(String input) {
        System.out.println();

        switch(input) {
            case "q":
                System.out.println("Goodbye!");
                System.exit(0);
            case "li":
                login();
                break;
            case "lob":
                library.printBooks();
                break;
            case "cob":
                checkoutBook();
                break;
            case "rb":
                returnBook();
                break;
            case "lom":
                library.printMovies();
                break;
            case "com":
                checkoutMovie();
                break;
        }
    }

    private void login() {
//        TODO
        System.out.println("log in here");
    }

    private String bookInput() {
        InputReader bookInputReader = new InputReader("book");
        bookInputReader.run();
        return bookInputReader.getInput();
    }

    private String movieInput() {
        InputReader movieInputReader = new InputReader("movie");
        movieInputReader.run();
        return movieInputReader.getInput();
    }

    private void checkoutBook() {
        library.checkoutBook(bookInput());
    }

    private void checkoutMovie() { library.checkoutMovie(movieInput()); }

    private void returnBook() {
        library.returnBook(bookInput());
    }
}
