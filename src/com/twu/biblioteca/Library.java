package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<Book>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void printBooks() {
        System.out.println("Title | Author | Year of publication");

        books.stream().filter(b -> b.available == true )
                .forEach(book -> book.printBook());

        System.out.println();
    }

    public void checkoutBook(String title) {
        boolean exists = false;

        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                exists = true;
                b.available = false;
                System.out.println("Thank you! Enjoy the book");
            }
        }

        if (exists == false) {
            System.out.println("Sorry, that book is not available");
        }
    }

    public void returnBook(String title) {
        boolean exists = false;

        for (Book b : books) {
            if (b.getTitle().equals(title) && !b.available) {
                exists = true;
                b.available = true;
                System.out.println("Thank you for returning the book");
            }
        }

        if (exists == false) {
            System.out.println("That is not a valid book to return");
        }
    }
}
