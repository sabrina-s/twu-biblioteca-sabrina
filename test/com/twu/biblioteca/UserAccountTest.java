package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserAccountTest {
    private UserAccount userAccount;

    @Before
    public void beforeEach() {
        userAccount = new UserAccount("000-0001", "password123");
    }

    @Test
    public void getLibraryNumberShouldReturnLibraryNumber() {
        assertEquals(userAccount.getLibraryNumber(), "000-0001");
    }

    @Test
    public void isValidShouldReturnTrueIfInputPasswordIsCorrect() {
        String input = "password123";
        assertThat(userAccount.isValid(input), is(true));
    }

    @Test
    public void isValidShouldReturnFalseIfInputPasswordIsWrong() {
        String input = "wrong-password";
        assertThat(userAccount.isValid(input), is(false));
    }
}
