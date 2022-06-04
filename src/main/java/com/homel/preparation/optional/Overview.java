package com.homel.preparation.optional;

import java.util.Optional;

public class Overview {
    public void printNullable(String str) {
        Optional.ofNullable(str).ifPresent(System.out::println);
    }

    public void printNullableOrElse(String str) {
        Optional.ofNullable(str).ifPresentOrElse(System.out::println, () -> System.out.println("Null, sorry"));
    }

    public static void main(String[] args) {
        Overview overview = new Overview();

        overview.printNullable("printNullable called");
        overview.printNullable(null);

        overview.printNullableOrElse("printNullableOrElse called");
        overview.printNullableOrElse(null);



//        String s = "val";
//
//        String val = Optional.ofNullable(s)
//                .filter(str -> !str.isEmpty())
//                .filter(str -> str.contains("val"))
//                .orElseGet(() -> "f");
//
//        System.out.println(val);
    }
}
