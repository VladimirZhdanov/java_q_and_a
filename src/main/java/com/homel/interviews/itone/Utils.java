package com.homel.interviews.itone;

import java.util.Arrays;
import java.util.function.Function;

public class Utils {

    // Дан набор строк, необходимо написать функцию, которая по данному набору
    // конструирует строку, состоящую
    // из элементов набора разделённых заданным набором символов.

    public static <T> String constructString(Iterable<T> objects, String delimiter, Function<T, String> function) {
        StringBuilder sb = new StringBuilder();

        for (T str : objects) {
            sb.append(function.apply(str));
            sb.append(delimiter);
        }

        if (sb.length() > 0) {
            sb.setLength(sb.length() - delimiter.length());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = constructString(Arrays.asList(new MyObject("Леха"),
                        new MyObject("не"), new MyObject("нюхай")), " ",
                it -> it.myString);

        System.out.println(result);
    }

    static class MyObject {
        String myString;
        int myInt;

        public MyObject(String myString) {
            this.myString = myString;
            this.myInt = 1;
        }
    }
}
