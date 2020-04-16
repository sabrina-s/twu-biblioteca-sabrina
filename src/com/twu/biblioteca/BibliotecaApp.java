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
            case "0":
                System.out.println("Goodbye!");
                System.exit(0);
            case "1":
                library.printBooks();
                break;
            case "2":
                checkoutBook();
                break;
            case "3":
                returnBook();
                break;
        }
    }

    private String bookInput() {
        InputReader bookInputReader = new InputReader("book");
        bookInputReader.run();
        return bookInputReader.getInput();
    }

    private void checkoutBook() {
        library.checkoutBook(bookInput());
    }

    private void returnBook() {
        library.returnBook(bookInput());
    }
}
