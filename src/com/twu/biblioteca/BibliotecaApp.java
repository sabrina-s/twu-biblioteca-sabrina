package com.twu.biblioteca;

import java.util.Scanner;

import static com.twu.biblioteca.Constants.WELCOME_MESSAGE;

public class BibliotecaApp {
    private IPrinter printer;
    private Library library;
    private UserRepository userRepository;
    private Menu menu;
    private Boolean authorized = false;

    public BibliotecaApp(IPrinter printer, Library library, UserRepository userRepository, Menu menu) {
        this.printer = printer;
        this.library = library;
        this.userRepository = userRepository;
        this.menu = menu;
    }

    public boolean execute() {
//        print welcome message
        printer.print(WELCOME_MESSAGE);

//        display menu
        if (authorized) {
            menu.printRestrictedOptions();
        } else {
            menu.printOptions();
        }

//        get user menu input
        InputReader menuInputReader = new InputReader("menu", authorized);
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
        Scanner loginScanner = new Scanner(System.in);

        System.out.print("Please enter your library number (e.g. 111-1111): ");
        String libraryNumber = loginScanner.nextLine();

        System.out.print("Please enter your password: ");
        String password = loginScanner.nextLine();

        boolean loginIsValid = userRepository.loginIsValid(libraryNumber, password);

        if (loginIsValid) {
            authorized = true;
        } else {
            printer.print("Invalid library number/password.");
        }
    }

    private String bookInput() {
        InputReader bookInputReader = new InputReader("book", authorized);
        bookInputReader.run();
        return bookInputReader.getInput();
    }

    private String movieInput() {
        InputReader movieInputReader = new InputReader("movie", authorized);
        movieInputReader.run();
        return movieInputReader.getInput();
    }

    private void checkoutBook() {
        library.checkoutBook(bookInput(), userRepository.getLoggedInUser());
    }

    private void checkoutMovie() { library.checkoutMovie(movieInput()); }

    private void returnBook() {
        library.returnBook(bookInput());
    }
}
