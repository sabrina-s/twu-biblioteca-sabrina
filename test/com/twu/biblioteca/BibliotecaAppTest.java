package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

public class BibliotecaAppTest {
    @Test
    public void executeShouldCallPrint() {
        SpyPrinter spy = new SpyPrinter();
        BibliotecaApp app = new BibliotecaApp(spy);

        app.execute();

        assertTrue(spy.isCalled);
    }

    @Test
    public void executeShouldPrintWelcomeMessage() {
        MockPrinter mock = new MockPrinter();
        BibliotecaApp app = new BibliotecaApp(mock);

        app.execute();

        assertThat(mock.content, containsString("Welcome"));
    }

    private class SpyPrinter implements IPrinter {
        public Boolean isCalled = false;

        @Override
        public void print(String message) {
            this.isCalled = true;
        }
    }

    private class MockPrinter implements IPrinter {
        public String content;

        @Override
        public void print(String message) {
            this.content = message;
        }
    }
}
