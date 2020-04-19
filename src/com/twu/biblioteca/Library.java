package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library extends Printer {
    private ArrayList<Book> books;
    private ArrayList<Movie> movies;

    public Library() {
        this.books = new ArrayList<>();
        this.movies = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMovie(Movie movie) { movies.add(movie); };

    public ArrayList<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(b -> b.available == true ).collect(Collectors.toList());
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void printBooks() {
        print("Title | Author | Year");
        getAvailableBooks().forEach(book -> print(book.getDetails()));
        print("-----------------------");
    }

    public void checkoutBook(String title) {
        boolean exists = false;

        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                exists = true;
                b.available = false;
                print("Thank you! Enjoy the book");
                print("-----------------------");
            }
        }

        if (exists == false) {
            print("Sorry, that book is not available");
            print("-----------------------");
        }
    }

    public void returnBook(String title) {
        boolean exists = false;

        for (Book b : books) {
            if (b.getTitle().equals(title) && !b.available) {
                exists = true;
                b.available = true;
                print("Thank you for returning the book");
                print("-----------------------");
            }
        }

        if (exists == false) {
            print("That is not a valid book to return");
            print("-----------------------");
        }
    }
}
