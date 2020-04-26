package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class UserAccountTest {
    private UserAccount userAccount;

    @Before
    public void beforeEach() {
        userAccount = new UserAccount("000-0001", "password123",
                "Sabrina", "sabrina@gmail.com", "98765432");
    }

    @Test
    public void getLibraryNumberShouldReturnLibraryNumber() {
        assertEquals(userAccount.getLibraryNumber(), "000-0001");
    }

    @Test
    public void isValidPasswordShouldReturnTrueIfPasswordIsCorrect() {
        String pw = "password123";
        assertThat(userAccount.isValidPassword(pw), is(true));
    }

    @Test
    public void isValidPasswordShouldReturnFalseIfInputPasswordIsWrong() {
        String pw = "wrong-password";
        assertThat(userAccount.isValidPassword(pw), is(false));
    }
}
