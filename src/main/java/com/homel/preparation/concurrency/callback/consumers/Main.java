package com.homel.preparation.concurrency.callback.consumers;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) {
        ConsumerCallback consumerCallback = new ConsumerCallback();
        int ageDifference = 10;
        AtomicInteger newAge1 = new AtomicInteger();
        int initialAge = 20;
        consumerCallback.getAge(initialAge, (initialAge1) -> {
            consumerCallback.increaseAge(initialAge, ageDifference, (newAge) -> {
                System.out.printf("New age ==> %s", newAge);
                newAge1.set(newAge);
            });
        });
    }
}
