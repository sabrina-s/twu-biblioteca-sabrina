package com.twu.biblioteca;
import java.util.Scanner;

import static com.twu.biblioteca.Constants.WELCOME_MESSAGE;

public class BibliotecaApp {
    private IPrinter printer;
    private Library library;
    private Menu menu;
    private InputReader inputReader;

    public BibliotecaApp(IPrinter printer, Library library, Menu menu, InputReader inputReader) {
        this.printer = printer;
        this.library = library;
        this.menu = menu;
        this.inputReader = inputReader;
    }

    public boolean execute() {
//        print welcome message
        printer.print(WELCOME_MESSAGE);

//        display menu
        menu.printOptions();

//        get user input
        InputReader menuInputReader = new InputReader("menu");
        menuInputReader.run();
        String menuInput = menuInputReader.input;

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
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter title of book: ");
                String bookToCheckout = scanner.nextLine();
                library.checkoutBook(bookToCheckout);
                break;
        }
    }
}
