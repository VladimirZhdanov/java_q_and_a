package com.homel.preparation.generics;

import static com.homel.preparation.generics.Test.fun;

public class Test {

    public static void main(String[] args) {
        fun(4);
    }

    public static void fun(int x) {

        if(x > 0) {

            fun(--x);

            System.out.print(x + " ");

            fun(--x);

        }

    }
}
