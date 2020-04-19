package com.twu.biblioteca;

public class Book {
    private String title;
    private String author;
    private int year;
    protected boolean available = true;

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getDetails() {
        return getTitle() + " | "
                + getAuthor() + " | "
                + getYear();
    }
}
