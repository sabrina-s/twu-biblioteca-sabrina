package com.twu.biblioteca;

import java.util.ArrayList;

public class UserAccount {
    private String libraryNumber;
    private String password;
    private ArrayList<Book> books;
    private String name;
    private String email;
    private String phoneNumber;

    public UserAccount(String libraryNumber, String password, String name, String email, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.books = new ArrayList<>();
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void showProfile() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
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

    public ArrayList<Book> getBooks() { return books; }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void showBooks() {
        for (Book b : books) {
            System.out.println(b.getDetails());
        }
    }
}
