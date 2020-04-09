package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;

public class LibraryTest {
    Library library = new Library();
    Book book1 = new Book("Test book", "Alice", 1997);
    Book book2 = new Book("Test book 2", "Bob", 2000);
    Book book3 = new Book("Test book 3", "Corey", 1986);

    @Before
    public void beforeEach() {
        ArrayList<Book> books =  new ArrayList<Book>();
        library.addBook(book1);
        library.addBook(book2);
    }

    @Test
    public void addBookShouldAddBookToLibrary() {
        library.addBook(book3);

        assertThat(library.getBooks(), hasItems(book1, book2));
    }

    @Test
    public void getBooksShouldReturnAllBooksInLibrary() {
        assertThat(library.getBooks().size(), is(2));
        assertThat(library.getBooks(), hasItems(book1, book2));
    }
}

