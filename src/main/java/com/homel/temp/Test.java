package com.homel.temp;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> strings = List.of("1", "2", "3");

        boolean isTheSame = true;

        strings.stream()
                .filter(it -> !isTheSame || !it.equals("2"))
                .forEach(System.out::println);

        strings.stream()
                .filter(it -> !(isTheSame && it.equals("2")))
                .forEach(System.out::println);



    }
}
