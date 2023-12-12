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

        List<? super Animal> animalList = new ArrayList<>();

        animalList.add(new Cat());
        animalList.add(new LuxCat());
        //animalList.add(new Dog()); //error

        List<? extends Animal> animalList2 = new ArrayList<>();

        //animalList2.add(new Cat()); //error
        //animalList2.add(new LuxCat()); //error
        //animalList2.add(new Dog()); //error
        animalList2.add(null); //only null

        List<?> animalList3 = new ArrayList<>();

        //animalList3.add(new Cat()); //error
        //animalList3.add(new LuxCat()); //error
        //animalList3.add(new Dog()); //error
        animalList3.add(null); //only null

        List<Animal> animalList4 = new ArrayList<>();
        animalList4.add(new Cat());
        animalList4.add(new LuxCat());
        animalList4.add(new Dog());
        animalList4.add(null);

    }
}
