package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class BookTest {
    public Book book;

    @Before
    public void beforeEach() {
        book = new Book("Nineteen Eighty-Four", "George Orwell", 1949);
    }

    @Test
    public void getTitleShouldGetBookTitle() {
        assertThat(book.getTitle(), is(equalTo("Nineteen Eighty-Four")));
    }

    @Test
    public void getAuthorShouldGetBookAuthor() {
        assertThat(book.getAuthor(), is(equalTo("George Orwell")));
    }

    @Test
    public void getYearShouldGetBookYear() {
        assertThat(book.getYear(), is(equalTo(1949)));
    }

    @Test
    public void getDetailsShouldGetBookDetails() {
        assertEquals(book.getDetails(), "Nineteen Eighty-Four | George Orwell | 1949");
    }
}
