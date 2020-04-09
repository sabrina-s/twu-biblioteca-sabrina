package com.twu.biblioteca.print;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void executeShouleHaveBeenCallPrintln() {
        SpyPrinter spy = new SpyPrinter();
        App app = new App(spy);

        app.execute();

        assertTrue(spy.isCall);
    }

    @Test
    public void excuterShouldCallPrintnWithMessage() {
        MockPrinter mock = new MockPrinter();
        App app = new App(mock);

        app.execute();

        assertEquals("my message", mock.actual);
    }

    private class SpyPrinter implements IPrinter {
        public Boolean isCall = false;

        @Override
        public void println(String message) {
            this.isCall = true;
        }
    }

    private class MockPrinter implements IPrinter {
        public String actual;
        @Override
        public void println(String message) {
            this.actual = message;
        }
    }
}
