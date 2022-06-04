package com.homel.preparation.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIIntro {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(11, 1, 2, 3, 4, 5, 6, 7, 7, 8);

        var result = integers.stream().filter(item -> item > 5).collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().skip(5L).collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().distinct().collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().map(item -> item + 1).collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().peek(System.out::println).collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().limit(2).collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().sorted().collect(Collectors.toList());
        System.out.println(result);

        result = integers.stream().sorted((first, second) -> second.compareTo(first)).collect(Collectors.toList());
        System.out.println(result);

        var resultInt = integers.stream().findFirst().orElse(0);
        System.out.println(resultInt);

        resultInt = integers.stream().findAny().orElse(0);
        System.out.println(resultInt);

        var resultLong = integers.stream().count();
        System.out.println(resultLong);

        resultInt = integers.stream().min((item1, item2) -> item1.compareTo(item2)).orElse(0);
        System.out.println(resultInt);

        resultInt = integers.stream().max((item1, item2) -> item1.compareTo(item2)).orElse(0);
        System.out.println(resultInt);

        resultInt = integers.stream().reduce((item1, item2) -> item1 + item2).orElse(0);
        System.out.println(resultInt);
    }
}
