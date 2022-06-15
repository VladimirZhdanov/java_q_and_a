package com.homel.preparation.concurrency.threadlocal;

public class Main {
    public static void main(String[] args) {
       threadLocalWithUserContext();

        //sharedMapWithUserContext();
    }

    private static void threadLocalWithUserContext() {
        ThreadLocalWithUserContext firstUser
                = new ThreadLocalWithUserContext(1);
        ThreadLocalWithUserContext secondUser
                = new ThreadLocalWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();
    }

    private static void sharedMapWithUserContext() {
        SharedMapWithUserContext firstUser = new SharedMapWithUserContext(1);
        SharedMapWithUserContext secondUser = new SharedMapWithUserContext(2);
        new Thread(firstUser).start();
        new Thread(secondUser).start();

        System.out.println(SharedMapWithUserContext.userContextPerUserId.size()); //2
    }
}
