package com.homel.interviews.luxsoft.interfaces.problem2;

public interface Interface <T> {

   // abstract void fooAbstract();

    T foo();

    default void fooDefault() {
        System.out.println("from Interface2");
    }
}
