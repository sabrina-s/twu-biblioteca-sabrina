package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public final class Constants {
    public static final String WELCOME_MESSAGE =
            "Welcome to Biblioteca. Your one-stop-shop " +
            "for great book titles in Bangalore!\n";
    public static final ArrayList<String> VALID_PUBLIC_INPUTS =
            new ArrayList<>(Arrays.asList(
                    "q", "li", "lob", "lom"));
    public static final ArrayList<String> VALID_RESTRICTED_INPUTS =
            new ArrayList<>(Arrays.asList(
                    "q", "lob", "lom", "li", "cob", "rb", "com", "inv"));
}
