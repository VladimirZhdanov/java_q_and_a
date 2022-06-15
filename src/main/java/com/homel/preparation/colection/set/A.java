package com.homel.preparation.colection.set;

import java.util.Objects;

public class A {
    int i;
    String str;

    public A(int i, String str) {
        this.i = i;
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        A a = (A) o;
        return i == a.i && Objects.equals(str, a.str);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(i, str);
        return 1;
    }
}
