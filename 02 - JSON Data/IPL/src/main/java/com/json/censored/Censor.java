package com.json.censored;

public class Censor {
    public static String apply(String input) {
        return input.replaceAll("(\\b\\w+)$", "****");
    }

    public static String redacted(String input) {
        return "REDACTED";

    }
}

