package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRepository {
    private ArrayList<UserAccount> userAccounts = new ArrayList<>(Arrays.asList(
            new UserAccount("000-0001", "password111")));

    public UserRepository() {}

    public boolean loginIsValid(String libraryNumber, String password) {
        boolean valid = false;

        for (UserAccount ua : userAccounts) {
            if (ua.isValidLibraryNumber(libraryNumber) && ua.isValidPassword(password)) {
                valid = true;
            }
        }

        return valid;
    }
}
