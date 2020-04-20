package com.twu.biblioteca;

public class Movie {
    private String name;
    private String director;
    private int year;
    private int rating;
    protected boolean available = true;

    public Movie(String name, String director, int year, int rating) {
        this.name = name;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }

    public Movie(String name, String director, int year) {
        this.name = name;
        this.director = director;
        this.year = year;
    }

    public String getRating() {
        return (rating == 0) ? "unrated" : Integer.toString(rating);
    }

    public String getName() { return name; }

    public String getDirector() { return director; }

    public int getYear() { return year; }

    public String getDetails() {
        return getName() + " | "
                + getDirector() + " | "
                + getYear() + " | "
                + getRating();
    }
}
