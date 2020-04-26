package com.twu.biblioteca;

import java.util.ArrayList;

public class UserAccount {
    private String libraryNumber;
    private String password;
    private ArrayList<Book> books;

    public UserAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.books = new ArrayList<>();
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean isValidLibraryNumber(String libraryNumber) {
        return libraryNumber.equals(this.libraryNumber);
    }

    public boolean isValidPassword(String inputPassword) {
        return inputPassword.equals(password);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle());
        }
    }
}
