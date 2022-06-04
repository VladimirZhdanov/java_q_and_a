package com.homel.interviews.luxsoft.interfaces.problem1;

public class Clazz implements Interface1, Interface2{
    @Override
    public void foo() {
        Interface1.super.foo();
    }
}
