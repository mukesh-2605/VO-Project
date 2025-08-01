package org.example;

public class Helper {
    public static String show(String val) {
        return (val != null && !val.trim().isEmpty()) ? val : "-";
    }
}
