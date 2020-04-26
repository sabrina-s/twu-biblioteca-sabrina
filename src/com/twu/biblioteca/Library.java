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

    public void addMovie(Movie movie) { movies.add(movie); }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public List<Book> getAvailableBooks() {
        return books.stream().filter(b -> b.available).collect(Collectors.toList());
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public List<Movie> getAvailableMovies() {
        return movies.stream().filter(m -> m.available).collect(Collectors.toList());
    }

    public void printBooks() {
        print("Title | Author | Year");
        getAvailableBooks().forEach(book -> print(book.getDetails()));
        print("-----------------------");
    }

    public void printMovies() {
        print("Name | Director | Year | Rating");
        getAvailableMovies().forEach(movie -> print(movie.getDetails()));
        print("-----------------------");
    }

    public void checkoutBook(String title, UserAccount ua) {
        boolean exists = false;

        for (Book b : books) {
            if (b.getTitle().equals(title)) {
                exists = true;
                b.available = false;
                ua.addBook(b);
                print("Thank you! Enjoy the book");
                print("-----------------------");
            }
        }

        if (!exists) {
            print("Sorry, that book is not available");
            print("-----------------------");
        }
    }

    public void checkoutMovie(String name) {
        boolean exists = false;

        for (Movie m : movies) {
            if (m.getName().equals(name)) {
                exists = true;
                m.available = false;
                print("Thank you! Enjoy the movie");
                print("-----------------------");
            }
        }

        if (!exists) {
            print("Sorry, that movie is not available");
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

        if (!exists) {
            print("That is not a valid book to return");
            print("-----------------------");
        }
    }
}
