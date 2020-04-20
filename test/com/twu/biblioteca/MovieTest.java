package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.CoreMatchers.equalTo;

public class MovieTest {
    private Movie movieWithRating;
    private Movie movieWithoutRating;

    @Before
    public void beforeEach() {
        movieWithRating = new Movie("Movie1", "Director1", 2001, 9);
        movieWithoutRating = new Movie("Movie2", "Director2", 2002);
    }

    @Test
    public void getNameShouldGetMovieName() {
        assertThat(movieWithRating.getName(), is(equalTo("Movie1")));
    }

    @Test
    public void getDirectorShouldGetMovieDirector() {
        assertThat(movieWithRating.getDirector(), is(equalTo("Director1")));
    }

    @Test
    public void getYearShouldGetMovieYear() {
        assertThat(movieWithRating.getYear(), is(equalTo(2001)));
    }

    @Test
    public void getRatingShouldGetMovieRatingIfExists() {
        assertThat(movieWithRating.getRating(), is(equalTo("9")));
    }

    @Test
    public void getRatingShouldReturnUnratedIfNonexistent() {
        assertThat(movieWithoutRating.getRating(), is(equalTo("unrated")));
    }

    @Test
    public void getDetailsShouldGetMovieDetails() {
        assertEquals(movieWithoutRating.getDetails(), "Movie2 | Director2 | 2002 | unrated");
    }
}
