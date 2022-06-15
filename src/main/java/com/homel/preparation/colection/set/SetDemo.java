package com.homel.preparation.colection.set;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<A> set = new HashSet<>();

        A a1 = new A(1, "1");
        A a2 = new A(2, "2");

        set.add(a1);
        set.add(a2);

        System.out.println(set.size());
    }

}
