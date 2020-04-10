package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;

public class LibraryTest {
    Library library = new Library();
    private Book book1;
    private Book book2;
    private Book book3;

    @Before
    public void beforeEach() {
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void addBookShouldAddBookToLibrary() {
        library.addBook(book3);

        assertThat(library.getBooks(), hasItems(book1, book2, book3));
    }

    @Test
    public void getBooksShouldReturnAllBooksInLibrary() {
        assertThat(library.getBooks().size(), is(2));
        assertThat(library.getBooks(), hasItems(book1, book2));
    }

    @Test
    public void printBooksShouldPrintDetailsOfBooks() {
        library.printBooks();

        verify(book1).printBook();
        verify(book2).printBook();
    }
}
