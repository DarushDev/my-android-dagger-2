package com.example.myandroiddagger2.app;

public class StringUtils {

    private StringUtils() {
    }

    /**
     * Strips off a potential ", " from the front of a string
     *
     * @param inString A string that may have a ", " prefix
     * @return A string with ", " stripped from the front
     */
    public static String stripPrefix(String inString) {
        if (inString.startsWith(", ")) {
            return inString.replaceFirst(", ", "");
        }
        return inString;
    }

}
