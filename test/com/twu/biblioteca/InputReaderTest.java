package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.io.*;

public class InputReaderTest {
    private InputStream systemIn = System.in;
    private PrintStream systemOut = System.out;

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

    @After
    public void reset() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void getInputShouldDisplayInstructions() {
        inputReader.getInput();

        assertThat(output.toString(), containsString("Enter option number:"));
    }

    @Test
    public void getInputShouldReceiveUserInput() {
        assertEquals(userInput, inputReader.getInput());
    }

//        TODO: implement enum to eliminate Primitive Obsession
    @Test
    public void getInputShouldPromptUserToTryAgainIfInputIsInvalid() {
        userInput = "-1\n1";
        input = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(input);

        inputReader.getInput();

        assertThat(output.toString(), containsString("Please select a valid option!"));
    }
}
