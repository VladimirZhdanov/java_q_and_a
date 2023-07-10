package com.homel.preparation.functionalinterfaces;

public class Predicate {

    public static void main(String[] args) {
        foo(10, it -> it > 0);
    }

    public static void foo(int data, CustomPredicate<Integer> customPredicate) {
        System.out.println(customPredicate.test(data));
    }

    @FunctionalInterface
    public interface CustomPredicate<T> {
        boolean test(T t);
    }
}


