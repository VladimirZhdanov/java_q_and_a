package com.homel.interviews.vtb;

public class StaticShit {
    static void perform() {
        System.out.println("Hi");
    }

    private static StaticShit x;

    public static void main(String s[]) {
        //x.perform(); // корректно ли это выражение?
    }
}
