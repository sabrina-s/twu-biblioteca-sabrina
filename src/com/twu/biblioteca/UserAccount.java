package com.twu.biblioteca;

public class UserAccount {
    private String libraryNumber;
    private String password;

    public UserAccount(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

    public boolean isValid(String inputPassword) {
        return inputPassword == password;
    }
}
