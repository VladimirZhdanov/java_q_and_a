package com.homel.preparation.string;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Abbreviation {

    private static Map<String, String> map = new HashMap<>();
    static {
        map.put("публичное акционерное общество", "ПАО");
        map.put("непубличное акционерное общество", "НАО");
        map.put("общество с ограниченной ответственностью", "ООО");
    }

    public static void main(String[] args) {
        String testString1 = "bla bla (публичное акционерное общество) bla bla";
        String testString2 = "bla bla (Общество с ограниченной ответственностью) bla bla";
        String testString3 = "bla bla (Закрытое акционерное общество) bla bla";
        String testString4 = "bla bla (непубличное Акционерное общество) bla bla";


        System.out.println(getRightString(testString1));
        System.out.println(getRightString(testString2));
        System.out.println(getRightString(testString3));
        System.out.println(getRightString(testString4));
    }


    private static String makeAbbreviation(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

        String[] strings = s.split(" ");

        StringBuilder sb = new StringBuilder();

        for (String string : strings) {
            sb.append(string.charAt(0));
        }

        return sb.toString().toUpperCase(Locale.ROOT);
    }

    private static String getRightString(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }

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

        String fullName = s.substring(beginIndex + 1, endIndex);
        String key = s.substring(beginIndex + 1, endIndex).toLowerCase(Locale.ROOT);

        if (map.containsKey(key)) {
            return s.replace(fullName, map.get(key));
        }
        return s.replace(fullName, makeAbbreviation(fullName));
    }
}
