package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class LibraryTest {
    Library library = new Library();
    UserAccount user = new UserAccount("111-1111", "password");
    private Book book1;
    private Book book2;
    private Book book3;
    private Movie movie1;
    private Movie movie2;

    private PrintStream systemOut = System.out;
    private ByteArrayOutputStream output;

    @Before
    public void beforeEach() {
        book1 = new Book("Book1", "Author1", 2001);
        book2 = new Book("Book2", "Author2", 2002);
        book3 = new Book("Book3", "Author3", 2003);
        movie1 = new Movie("Movie1", "Director1", 2001, 8);
        movie2 = new Movie("Movie2", "Director2", 2002);
        library.addBook(book1);
        library.addBook(book2);
        library.addMovie(movie1);
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
    public void addMovieShouldAddMovieToLibrary() {
        library.addMovie(movie2);

        assertThat(library.getMovies(), hasItems(movie1, movie2));
    }

    @Test
    public void getBooksShouldReturnAllBooksInLibrary() {
        assertThat(library.getBooks().size(), is(2));
        assertThat(library.getBooks(), hasItems(book1, book2));
    }

    @Test
    public void getAvailableBooksShouldReturnOnlyAvailableBooks() {
        book1.available = true;
        book2.available = false;

        assertThat(library.getAvailableBooks().size(), is(1));
        assertThat(library.getAvailableBooks(), hasItems(book1));
    }

    @Test
    public void getMoviesShouldReturnAllMoviesInLibrary() {
        assertThat(library.getMovies().size(), is(1));
        assertThat(library.getMovies(), hasItems(movie1));
    }

    @Test
    public void getAvailableMoviesShouldReturnOnlyAvailableMovies() {
        library.addMovie(movie2);
        movie1.available = false;

        assertThat(library.getAvailableMovies().size(), is(1));
        assertThat(library.getAvailableMovies(), hasItems(movie2));
    }

    @Test
    public void printBooksShouldPrintDetailsOfBooks() {
        library.printBooks();

        assertThat(output.toString(),
                containsString("Title | Author | Year"));
        assertThat(output.toString(),
                both(containsString("Book1")).
                and(containsString("Book2")));
    }

    @Test
    public void checkoutBookShouldCheckoutBookIfValid() {
        library.checkoutBook(book1.getTitle(), user);

        assertThat(book1.available, equalTo(false));
        assertThat(output.toString(), containsString(
                "Thank you! Enjoy the book"));
        assertEquals(user.getBooks().size(), 1);
    }

    @Test
    public void checkoutBookShouldReturnErrorMessageIfInvalid() {
        library.checkoutBook("Non-existent Book", user);

        assertThat(book1.available, equalTo(true));
        assertThat(output.toString(), containsString(
                "Sorry, that book is not available"));
        assertEquals(user.getBooks().size(), 0);
    }

    @Test
    public void checkoutMovieShouldCheckoutMovieIfValid() {
        library.checkoutMovie(movie1.getName());

        assertThat(movie1.available, equalTo(false));
        assertThat(output.toString(), containsString(
                "Thank you! Enjoy the movie"));
    }

    @Test
    public void checkoutMovieShouldReturnErrorMessageIfInvalid() {
        library.checkoutMovie("Non-existent Movie");

        assertThat(movie1.available, equalTo(true));
        assertThat(output.toString(), containsString(
                "Sorry, that movie is not available"));
    }

    @Test
    public void returnBookShouldReturnBookIfValid() {
        library.checkoutBook(book1.getTitle(), user);
        library.returnBook(book1.getTitle(), user);

        assertThat(book1.available, equalTo(true));
        assertThat(output.toString(), containsString(
                "Thank you for returning the book"));
        assertEquals(user.getBooks().size(), 0);
    }

    @Test
    public void returnBookShouldReturnErrorMessageIfBookWasNotCheckedOut() {
        library.returnBook(book1.getTitle(), user);

        assertThat(output.toString(), containsString(
                "That is not a valid book to return"));
    }

    @Test
    public void returnBookShouldReturnErrorMessageIfBookDoesNotExist() {
        library.returnBook("Non-existent Book", user);

        assertThat(output.toString(), containsString(
                "That is not a valid book to return"));
    }
}
