package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.io.*;

public class InputReaderTest {
    private ByteArrayInputStream input;
    private ByteArrayOutputStream output;

    InputReader inputReader = new InputReader();
    String userInput = "1";

    @Before
    public void setup() {
        input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
    }

    @Test
    public void getInputShouldDisplayInstructions() {
        InputReader.getInput();

        assertThat(output.toString(), containsString("Enter option number:"));
    }

    @Test
    public void getInputShouldReceiveUserInput() {
        assertEquals(userInput, inputReader.getInput());
    }
}
