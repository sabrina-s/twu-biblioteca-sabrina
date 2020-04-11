package com.twu.biblioteca;

public class Book extends Printer {
    private String title;
    private String author;
    private int publicationYear;
    protected boolean available = true;

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void printBook() {
        print(getTitle() + " | "
                + getAuthor() + " | "
                + getPublicationYear()
        );
    }
}
