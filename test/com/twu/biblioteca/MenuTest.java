package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MenuTest {
    @Test
    public void getOptionsShouldReturnMenuOptions() {
        Menu menu = new Menu();

        ArrayList<String> options = menu.getOptions();

        assertThat(options.get(0), equalTo("1. List of books"));
    }
}
