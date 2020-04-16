package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest {
    Library library = new Library();
    private Book book1;
    private Book book2;
    private Book book3;

    private PrintStream systemOut = System.out;
    private ByteArrayOutputStream output;

    @Before
    public void beforeEach() {
        book1 = new Book("Book1", "Author1", 2001);
        book2 = new Book("Book2", "Author2", 2002);
        book3 = new Book("Book3", "Author3", 2003);
        library.addBook(book1);
        library.addBook(book2);
    }

    @Before
    public void setup() {
        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @After
    public void reset() {
        System.setOut(systemOut);
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

        assertThat(output.toString(),
                containsString("Title | Author | Year of publication"));
        assertThat(output.toString(),
                both(containsString("Book1")).
                and(containsString("Book2")));
    }

    @Test
    public void checkoutBookShouldCheckoutBookIfValid() {
        library.checkoutBook(book1.getTitle());

        assertThat(book1.available, equalTo(false));
        assertThat(output.toString(), containsString(
                "Thank you! Enjoy the book"));
    }

    @Test
    public void checkoutBookShouldReturnErrorMessageIfInvalid() {
        library.checkoutBook("Non-existent Book");

        assertThat(book1.available, equalTo(true));
        assertThat(output.toString(), containsString(
                "Sorry, that book is not available"));
    }

    @Test
    public void returnBookShouldReturnBookIfValid() {
        library.checkoutBook(book1.getTitle());
        library.returnBook(book1.getTitle());

        assertThat(book1.available, equalTo(true));
        assertThat(output.toString(), containsString(
                "Thank you for returning the book"));
    }

    @Test
    public void returnBookShouldReturnErrorMessageIfBookWasNotCheckedOut() {
        library.returnBook(book1.getTitle());

        assertThat(output.toString(), containsString(
                "That is not a valid book to return"));
    }

    @Test
    public void returnBookShouldReturnErrorMessageIfBookDoesNotExist() {
        library.returnBook("Non-existent Book");

        assertThat(output.toString(), containsString(
                "That is not a valid book to return"));
    }
}
