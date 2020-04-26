package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class UserRepository {
    private ArrayList<UserAccount> userAccounts = new ArrayList<>(Arrays.asList(
            new UserAccount("000-0001", "password111")));
    private UserAccount loggedInUser;

    public UserRepository() {}

    public boolean loginIsValid(String libraryNumber, String password) {
        boolean valid = false;

        for (UserAccount ua : userAccounts) {
            if (ua.isValidLibraryNumber(libraryNumber) && ua.isValidPassword(password)) {
                valid = true;
                loggedInUser = ua;
            }
        }

        return valid;
    }

    public UserAccount getLoggedInUser() {
        return loggedInUser;
    }
}
