package org.example;

public class Helper {
    public static String show(String val) {
        return (val != null && !val.trim().isEmpty()) ? val : "-";
    }

    public static String showInt(Integer val) {
        return (val != null) ? String.valueOf(val) : "-";
    }
}
