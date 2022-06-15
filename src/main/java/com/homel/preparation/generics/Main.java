package com.homel.preparation.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Number[] numbers = new Integer[10];

        numbers[0] = 1;
        //numbers[1] = 1d; // error

        //List<Number> numberList = new ArrayList<Integer>(); // error

        //==================================================================

        List<? extends Number> numberList = new ArrayList<>();
        //numberList.add(Integer.MAX_VALUE); // error you can put only null

        //==================================================================

        List<? super Number> numberList2 = new ArrayList<>();
        //numberList2.add(new Object()); //error
        numberList2.add(1);
        numberList2.add(2d);
        numberList2.add(1.6f);

        numberList2.forEach(System.out::println);

        //==================================================================



    }
}
