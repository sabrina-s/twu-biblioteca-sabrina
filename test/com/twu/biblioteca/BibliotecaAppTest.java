package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.containsString;

public class BibliotecaAppTest {
    @Test
    public void executeShouldCallPrint() {
        SpyPrinter spyPrinter = new SpyPrinter();
        SpyLibrary spyLibrary = new SpyLibrary();
        BibliotecaApp app = new BibliotecaApp(spyPrinter, spyLibrary);

        app.execute();

        assertTrue(spyPrinter.isCalled);
    }

    @Test
    public void executeShouldPrintWelcomeMessage() {
        MockPrinter mockPrinter = new MockPrinter();
        MockLibrary mockLibrary = new MockLibrary();
        BibliotecaApp app = new BibliotecaApp(mockPrinter, mockLibrary);

        app.execute();

        assertThat(mockPrinter.content, containsString("Welcome"));
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

    private class SpyLibrary extends Library {}
    private class MockLibrary extends Library {}
}
