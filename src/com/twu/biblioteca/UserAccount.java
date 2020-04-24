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

    public boolean isValidLibraryNumber(String libraryNumber) {
        return libraryNumber.equals(this.libraryNumber);
    }

    public boolean isValidPassword(String inputPassword) {
        return inputPassword.equals(password);
    }
}
