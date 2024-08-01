package com.homel.interviews.raiffeisen.generics;

import java.util.ArrayList;
import java.util.List;

//pecs
public class Question {

    public static void main(String[] args) {

        Car c = new Car();
        Mercedes mercedes = new Mercedes();
        Vehicle vehicle = new Vehicle();

        List<? extends Car> mercedesList = new ArrayList<>(List.of(c, mercedes));
//
//        mercedesList.add(c);
//        mercedesList.add(mercedes);
//        mercedesList.add(vehicle);
//        mercedesList.add(null);
//
//        Car car = mercedesList.get(0);
//        Mercedes merce = mercedesList.get(0);
//        Vehicle v = mercedesList.get(0);
    }

}
