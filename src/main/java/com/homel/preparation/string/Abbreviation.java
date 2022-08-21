package com.homel.preparation.string;

import java.util.Locale;

public class Abbreviation {

    public static void main(String[] args) {
        String testString = "bla bla (публичное акционерное общество) bla bla";

        System.out.println(makeAbbreviation(getRightString(testString)));
    }


    private static String makeAbbreviation(String s) {
        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            sb.append(string.charAt(0));
        }

        return sb.toString().toUpperCase(Locale.ROOT);
    }

    private static String getRightString(String s) {
        int beginIndex = 0;
        int endIndex = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            if (c == '(') {
                beginIndex = i;
            }
            if (c == ')') {
                endIndex = i;
                break;
            }
        }

        return s.substring(beginIndex + 1, endIndex);
    }
}
